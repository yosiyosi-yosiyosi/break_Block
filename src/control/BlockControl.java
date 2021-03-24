package control;

import model.BlockBean;
import model.BlockModel;
import view.BlockView;

/**
 *  BlockControl
 *  コンストラクタ、スレッド処理
 *  ブロック崩しを操作する
 *  okd
 */
public class BlockControl extends Thread {

	//クラス変数
	BlockModel blockModel;

	BlockView blockView;

	BlockBean blockBean;

	/**
	 * コンストラクタ開始 【Method】
	 */
	public BlockControl(BlockView blockView) {

		this.blockView = blockView;

		this.blockBean = blockView.getBlockBean();

		this.blockModel = new BlockModel();
	}

	/**
	 * スレッド処理開始 【Method】
	 */
	public void threadStart() {

		//描画処理
		blockView.drawingProcess(blockBean);

		//スレッドの処理を一時停止させる

		try {
			Thread.sleep(100);

			//無限ループさせる
			while (true) {
				//現在の画像情報を取得
				blockBean = blockView.getBlockBean();

				//次の情報を取得
				blockBean = blockModel.judgement(blockBean);

				//新しい情報を更新
				blockView.setBlockBean(blockBean);

				//新しい情報を更新
				blockView.drawingProcess(blockBean);

				//条件① ビーン.ブロックの個数 が『０』の場合
				if (blockBean.getBlockQuantity() == 0) {

					//状態変更
					blockBean.setStatus(3);

					//ブロックが無くなったらゲーム終了
					blockView.nonBlockGameEnd();

					//条件② ビーン.状態 == 2
				} else if (blockBean.getStatus() == 2) {

					//ブロックが無くなったらゲーム終了
					blockView.nonBlockGameEnd();

				} else {

					//一時停止 実行時間間隔、書き換え
					Thread.sleep(blockBean.getRewriteTime());
				}
			}

		} catch (InterruptedException e) {
			System.out.println("終わりかも？(΄◉◞౪◟◉｀)");
			e.printStackTrace();
		}

	}

}
