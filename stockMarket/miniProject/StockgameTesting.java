package stockMarket.miniProject;

import java.io.BufferedReader;
import java.io.FileReader;

class StockGame extends Thread {

	private static double stockPrice = 100.00;
	private static int availableShares = 100;
	private static int tradeCount = 0;
	private String name;
	private int numShares;
	private String fileName;
	private static final Object sync = new Object();

	public StockGame(String name, String fileName) {

		this.name = name;
		this.fileName = fileName;
		this.numShares = 0;

	}

	@Override
	public void run() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String nextTreade;
			while ((nextTreade = br.readLine()) != null) {
				processTrade(nextTreade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void processTrade(String trade) {
		String[] parts = trade.split(",");
		if (parts.length != 2) {
			System.out.println("Error, invalid input!");
			return;
		}

		String action = parts[0];
		int share = Integer.parseInt(parts[1]);

		synchronized (sync) {
			System.out.println("-------------------------");
			System.out.println("Stock Price: " + stockPrice);
			System.out.println("Available Shares: " + availableShares);
			System.out.println("Trade number: " + (tradeCount + 1));
			System.out.println("Name: " + name);

			if ("BUY".equals(action)) {
				System.out.println("Purchasing " + share + " shares at " + stockPrice + "...");
				if (share > availableShares) {
					System.out.println("Insufficient shares available, cancelling order...");
					return;
				}

				numShares += share;
				availableShares -= share;
				stockPrice += (1.5 * share);

			} else if ("SELL".equals(action)) {
				System.out.println("Selling " + share + " shares at " + stockPrice + "...");
				if (share > numShares) {
					System.out.println("Insufficient owned shares, cancelling order...");
					return;
				}

				numShares -= share;
				availableShares += share;
				stockPrice -= (2.0 * share);

			} else {
				System.out.println("Error, invalid input!");
				return;
			}
			tradeCount++;
		}
	}
}

public class StockgameTesting {

	public static void main(String[] args) {
		
		try {
			StockGame[] stockTraders = {
					new StockGame("Xander", "src\\StockMarket\\miniProject\\TraderOneMoves.txt"),
					new StockGame("Afua", "src\\StockMarket\\miniProject\\TraderTwoMoves.txt") };
			for (int i = 0; i < stockTraders.length; i++) {
				stockTraders[i].start();
			}
			for (int i = 0; i < stockTraders.length; i++) {
				stockTraders[i].join();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}

	}

}
