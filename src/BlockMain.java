import view.BlockView;

/**
 * BlockMain
 * main処理を実行
 * okd
 */

public class BlockMain {

	public static void main(String[] args) {

		BlockView blockView = new BlockView();

		//画面サイズの設定
		blockView.setSize(400, 400);

		//画面を表示
		blockView.setVisible(true);

		//表示情報設定
		blockView.displayInformation();

	}

}
