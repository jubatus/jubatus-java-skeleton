import java.util.List;

import us.jubat.common.Datum;
import us.jubat.recommender.IdWithScore;
import us.jubat.recommender.RecommenderClient;

import org.msgpack.rpc.loop.EventLoop;

public class Client {
	public static final String HOST = "127.0.0.1";
	public static final int PORT = 9199;
	public static final String NAME = "";

	public void start() throws Exception {
		RecommenderClient r = new RecommenderClient(HOST, PORT, NAME, 5);

		try {
			Datum d;

			// user01
			d = new Datum().addNumber("movie_A", 5).addNumber("movie_B", 2)
					.addNumber("movie_C", 3);
			r.updateRow("user01", d);

			// user02
			d = new Datum().addNumber("movie_A", 2).addNumber("movie_B", 5)
					.addNumber("movie_C", 1);
			r.updateRow("user02", d);

			// user03
			d = new Datum().addNumber("movie_A", 5).addNumber("movie_B", 1)
					.addNumber("movie_C", 4);
			r.updateRow("user03", d);

			List<String> rows = r.getAllRows();
			for (String id : rows) {
				List<IdWithScore> result;
				result = r.similarRowFromId(id, 3);
				System.out.println(id + " is similar to: ");
				System.out.print("  ");
				for (IdWithScore tuple : result) {
					System.out.print(tuple.id + " (" + tuple.score + "), ");
				}
				System.out.println();
			}
		} finally {
			r.getClient().close();
		}
	}

	public static void main(String[] args) throws Exception {
		try {
			new Client().start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// msgpack-rpc-java does not stop the EventLoop automatically
			EventLoop.defaultEventLoop().shutdown();
			EventLoop.setDefaultEventLoop(null);
		}
	}
}
