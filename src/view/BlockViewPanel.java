package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import model.BlockBean;

/**
 * BlockViewPanel
 * オフスクリーン用の描画領域の作成
 * 画面情報を渡して書き換え
 * ダブルバッファの実行
 * okd
 */

public class BlockViewPanel extends Panel {

	//画像情報を保存するための変数
	BlockBean screenInformation;

	//オフスクリーングラフィックス
	Graphics offScreenGraphics;

	//オフスクリーンイメージ領域
	Image offScreenImage;

	//オフスクリーン用の描画領域を作成
	@Override
	public void setBounds(int x, int y, int width, int height) {

		//親クラスの境界セッター
		super.setBounds(x, y, width, height);

		//現在の画面幅取得
		int nowScreenWidth = this.getWidth();

		//現在の画面高さ取得
		int nowScreenHeight = this.getHeight();

		//描画領域作成
		offScreenImage = this.createImage(nowScreenWidth, nowScreenHeight);

		offScreenGraphics = offScreenImage.getGraphics();

	}

	//画面情報を渡して書き換え
	public void screenRewrite(BlockBean blockBean) {

		//ブロックビーンの入れ替え
		screenInformation = blockBean;

		//書き換え
		this.repaint();
	}

	//ダブルバッファを行う
	@Override
	public void update(Graphics graphics) {

		//画面情報Beanにしたがって描画メソッドを呼び出し
		drawScreen(graphics);

	}

	//画面情報Beanにしたがって描画
	public void drawScreen(Graphics graphics) {

		//条件1 【画面情報を保存するための変数が nullじゃなかったら】
		if (screenInformation != null) {

			//オフスクリーン領域の描画をいったん消去する
			offScreenGraphics.clearRect(
					0,0,
					screenInformation.getDrawingRangeWidth(),
					screenInformation.getDrawingRangeHeight());

			//ボールの描画
			offScreenGraphics.drawImage(
					screenInformation.getBallImage(),
					screenInformation.getBallCenterX(),
					screenInformation.getBallCenterY(),
					screenInformation.getBallWidth() * 2,
					screenInformation.getBallHeight() * 2, this);

			//カーソル(ラケット)の描画
			offScreenGraphics.drawImage(
					screenInformation.getRacketImage(),
					screenInformation.getRacketX(),
					screenInformation.getRacketY(),
					screenInformation.getRacketWidth(),
					screenInformation.getRacketHeight(), this);

			//繰り返し1
			for (int i = 0; i < screenInformation.getBlockExist().length; i++) {

				//条件2
				if (screenInformation.getBlockExist()[i] == 1) {
					//ブロックを描く
					offScreenGraphics.drawImage(
							screenInformation.getBlockImage(),
							screenInformation.getBlockX()[i],
							screenInformation.getBlockY()[i], 50, 20, this);
				}
			}
			//オフスクリーンイメージ領域描画
			graphics.drawImage(offScreenImage, 0, 0, this);

			//条件3
			if (screenInformation.getBlockQuantity() == 0) {
				Font font = new Font("Serif", Font.PLAIN, 50);
				graphics.setFont(font);
				graphics.setColor(Color.blue.darker());
				graphics.drawString("クリアー", 100, 200);
			}

			//条件4
			else if (screenInformation.getStatus() == 2) {
				Font font = new Font("Serif", Font.PLAIN, 50);
				graphics.setFont(font);
				graphics.setColor(Color.blue.darker());
				graphics.drawString("ゲームオーバー", 20, 200);

			}

		}
	}

}
