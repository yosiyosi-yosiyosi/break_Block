package model;

/**
 * BlockModel モデル、ロジック】
 * 位置を計算、情報格納
 * 変数名の頭文字の【hv】 は、【have】の略
 * okd
 */

public class BlockModel {

	/**
	 * 判定処理 【Method】
	 */
	public BlockBean judgement(BlockBean blockBean) {

		//ボールの中心X座標
		int hvBallCenterX = blockBean.getBallCenterX();

		//ボールの中心Y座標
		int hvBallCenterY = blockBean.getBallCenterY();

		//ボールの横幅
		int hvBallWidth = blockBean.getBallWidth();

		//ボールの縦幅
		int hvBallHeight = blockBean.getBallHeight();

		//ラケットの左上点のX座標
		int hvRacketX = blockBean.getRacketX();

		//ラケットの左上点のY座標
		int hvRacketY = blockBean.getRacketY();

		//ラケットの横幅
		int hvRacketWidth = blockBean.getRacketWidth();

		//ラケットの縦幅
		int hvRacketHeight = blockBean.getRacketHeight();

		//ブロック崩しの描画範囲の横幅
		int hvDrawingRangeWidth = blockBean.getDrawingRangeWidth();

		//ブロック崩しの描画範囲の縦幅
		int hvDrawingRangeHeight = blockBean.getDrawingRangeHeight();

		//次のボールのX座標増分量
		int hvBallNextX = blockBean.getBallNextX();

		//次のボールのY座標増分量
		int hvBallNextY = blockBean.getBallNextY();

		//配列のサイズ
		int arraySize = (blockBean.getBlockLine() * blockBean.getBlockColumn());

		//マイナス2する
//		int minus2 = -2;

		//条件【1】
		boolean conditions1 = (hvBallCenterY + hvBallHeight >= hvRacketY && hvBallCenterY +
				hvBallHeight <= hvRacketY + hvRacketHeight && hvBallCenterX + hvBallWidth >= hvRacketX
				&& hvBallCenterX <= hvRacketX + hvRacketWidth);

		//条件【2】
		boolean conditions2 = (hvBallCenterX < hvRacketX || hvBallCenterX + hvBallWidth > hvRacketX + hvRacketWidth);

		//条件【3】
		boolean conditions3 = (hvBallNextX == 0);

		//条件【4】
		boolean conditions4 = (hvBallNextX < hvRacketX);

		//条件【5】
		boolean conditions5 = (hvBallCenterX + hvBallWidth > hvRacketX + hvRacketWidth);

		//条件【6】
		boolean conditions6 = (hvBallCenterX < 0);

		//条件【7】
		boolean conditions7 = (hvBallCenterX + hvBallWidth > hvDrawingRangeWidth);

		//条件【8】
		boolean conditions8 = (hvBallCenterY < 0);

		//条件処理

		if (conditions1) {

			//次のボールのY増分量を[マイナス 2]で上へ返す
			hvBallNextY = -2;

			if (conditions2) {

				if (conditions3) {
					if (conditions4) {
						//左斜め上に返す
						hvBallNextX = -2;

					} else if (conditions5) {
						//右斜め上に返す
						hvBallNextX = 2;
					}

				} else if (!conditions3) {
					//ボールは垂直に返す
					hvBallNextX = 0;
				}
			}

		}
		if (conditions6) {
			//反転
			hvBallNextX = 2;
		}
		if (conditions7) {
			//反転
			hvBallNextX = -2;
		}
		if (conditions8) {
			//反転
			hvBallNextY = 2;
		}

		for (int i = 0; i < arraySize; i++) {
			//条件【9】
			if (blockBean.getBlockExist()[i] == 1) {
				//条件【10】
				if (hvBallCenterY + hvBallWidth >= blockBean.getBlockY()[i] &&
						hvBallCenterY <= blockBean.getBlockY()[i] + blockBean.getBlockHeight() &&
						hvBallCenterX + hvBallWidth >= blockBean.getBlockX()[i] &&
						hvBallCenterX <= blockBean.getBlockY()[i] + blockBean.getBlockWidth()) {

					//反転
					hvBallNextY = -hvBallNextY;
					//ブロックを消す
					blockBean.setBlockExist(i);
					//ブロックの数をセット
					blockBean.setBlockQuantity(-1);
				}
			}
		}

		//条件【11】 ボールのｙ座標 + ボールの高さ > ブロック崩しの描画範囲の縦幅 + 100
		if (hvBallCenterY + hvBallHeight > hvDrawingRangeHeight + 100) {
			//モードを終了状態に
			blockBean.setStatus(2);
		}
		//ボール位置に増量分追加した座標
		hvBallCenterX = hvBallCenterX + hvBallNextX;
		hvBallCenterY = hvBallCenterY + hvBallNextY;

		//次のボール位置のセット
		blockBean.setBallCenterX(hvBallCenterX);
		blockBean.setBallCenterY(hvBallCenterY);

		//次のボール増分量をセット
		blockBean.setBallNextX(hvBallNextX);
		blockBean.setBallNextY(hvBallNextY);

		return blockBean;

	}

}
