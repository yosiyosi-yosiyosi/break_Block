package model;

import java.awt.Image;

/**
 * ブロックビーン
 *　ブロックの初期状態をセット
 */
public class BlockBean {

	/**
	 * ボールのイメージ
	 */
	private Image ballImage;

	/**
	 * ラケットのイメージ
	 */
	private Image racketImage;

	/**
	 * ブロックのイメージ
	 */
	private Image blockImage;

	/**
	 * 実行時間間隔、書き換え時間（速度）
	 */
	private int rewriteTime;

	/**
	 * ボールの横幅
	 */
	private int ballWidth;

	/**
	 * ボールの縦幅
	 */
	private int ballHeight;

	/**
	 * ボールの中心のX座標
	 */
	private int ballCenterX;

	/**
	 * ボールの中心のY座標
	 */
	private int ballCenterY;

	/**
	 * 次のボールのX座標増分量
	 */
	private int ballNextX;

	/**
	 * 次のボールのY座標増分量
	 */
	private int ballNextY;

	/**
	 * ブロック崩しの描画範囲の横幅
	 */
	private int drawingRangeWidth;

	/**
	 * ブロック崩しの描画範囲の縦幅
	 */
	private int drawingRangeHeight;

	/**
	 * ラケットの左上点のX座標
	 */
	private int racketX;

	/**
	 * ラケットの左上点のY座標
	 */
	private int racketY;

	/**
	 * ラケットの横幅
	 */
	private int racketWidth;

	/**
	 * ラケットの縦幅
	 */
	private int racketHeight;

	/**
	 * ブロックがあるかどうかの判定
	 */
	private int[] blockExist;

	/**
	 * ブロックのX座標
	 */
	private int[] blockX;

	/**
	 * ブロックのY座標
	 */
	private int[] blockY;

	/**
	 * ブロックの幅
	 */
	private int blockWidth;

	/**
	 * ブロックの高さ
	 */
	private int blockHeight;

	/**
	 * ブロックのマージン
	 */
	private int blockMargin;

	/**
	 * ブロックの行
	 */
	private int blockLine;

	/**
	 * ブロックの列
	 */
	private int blockColumn;

	/**
	 * ブロックの個数
	 */
	private int blockQuantity;

	/**
	 * 状態
	 */
	private int status;

	/**
	 *　
	 */

	public Image getBallImage() {
		return ballImage;
	}

	public void setBallImage(Image ballImage) {
		this.ballImage = ballImage;
	}

	public Image getRacketImage() {
		return racketImage;
	}

	public void setRacketImage(Image racketImage) {
		this.racketImage = racketImage;
	}

	public Image getBlockImage() {
		return blockImage;
	}

	public void setBlockImage(Image blockImage) {
		this.blockImage = blockImage;
	}

	public int getRewriteTime() {
		return rewriteTime;
	}

	public void setRewriteTime(int rewriteTime) {
		this.rewriteTime = rewriteTime;
	}

	public int getBallWidth() {
		return ballWidth;
	}

	public void setBallWidth(int ballWidth) {
		this.ballWidth = ballWidth;
	}

	public int getBallHeight() {
		return ballHeight;
	}

	public void setBallHeight(int ballHeight) {
		this.ballHeight = ballHeight;
	}

	public int getBallCenterX() {
		return ballCenterX;
	}

	public void setBallCenterX(int ballCenterX) {
		this.ballCenterX = ballCenterX;
	}

	public int getBallCenterY() {
		return ballCenterY;
	}

	public void setBallCenterY(int ballCenterY) {
		this.ballCenterY = ballCenterY;
	}

	public int getBallNextX() {
		return ballNextX;
	}

	public void setBallNextX(int ballNextX) {
		this.ballNextX = ballNextX;
	}

	public int getBallNextY() {
		return ballNextY;
	}

	public void setBallNextY(int ballNextY) {
		this.ballNextY = ballNextY;
	}

	public int getDrawingRangeWidth() {
		return drawingRangeWidth;
	}

	public void setDrawingRangeWidth(int drawingRangeWidth) {
		this.drawingRangeWidth = drawingRangeWidth;
	}

	public int getDrawingRangeHeight() {
		return drawingRangeHeight;
	}

	public void setDrawingRangeHeight(int drawingRangeHeight) {
		this.drawingRangeHeight = drawingRangeHeight;
	}

	public int getRacketX() {
		return racketX;
	}

	public void setRacketX(int racketX) {
		this.racketX = racketX;
	}

	public int getRacketY() {
		return racketY;
	}

	public void setRacketY(int racketY) {
		this.racketY = racketY;
	}

	public int getRacketWidth() {
		return racketWidth;
	}

	public void setRacketWidth(int racketWidth) {
		this.racketWidth = racketWidth;
	}

	public int getRacketHeight() {
		return racketHeight;
	}

	public void setRacketHeight(int racketHeight) {
		this.racketHeight = racketHeight;
	}

	public int[] getBlockExist() {
		return blockExist;
	}

	public void setBlockExist(int blockExist) {
		this.blockExist[blockExist] = 0;
	}

	public int[] getBlockX() {
		return blockX;
	}

	public void setBlockX(int[] blockX) {
		this.blockX = blockX;
	}

	public int[] getBlockY() {
		return blockY;
	}

	public void setBlockY(int[] blockY) {
		this.blockY = blockY;
	}

	public int getBlockWidth() {
		return blockWidth;
	}

	public void setBlockWidth(int blockWidth) {
		this.blockWidth = blockWidth;
	}

	public int getBlockHeight() {
		return blockHeight;
	}

	public void setBlockHeight(int blockHeight) {
		this.blockHeight = blockHeight;
	}

	public int getBlockMargin() {
		return blockMargin;
	}

	public void setBlockMargin(int blockMargin) {
		this.blockMargin = blockMargin;
	}

	public int getBlockLine() {
		return blockLine;
	}

	public void setBlockLine(int blockLine) {
		this.blockLine = blockLine;
	}

	public int getBlockColumn() {
		return blockColumn;
	}

	public void setBlockColumn(int blockColumn) {
		this.blockColumn = blockColumn;
	}

	public int getBlockQuantity() {
		return blockQuantity;
	}

	public void setBlockQuantity(int blockQuantity) {
		this.blockQuantity = blockQuantity + blockQuantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * ブロックの初期状態をセット
	 */
	public void blockingset() {
		//ブロックがあるかどうかの判定
		blockExist = new int[blockLine * blockColumn];
		//ブロックのX座標
		blockX = new int[blockLine * blockColumn];
		//ブロックのY座標
		blockY = new int[blockLine * blockColumn];
		//ブロックの個数
		blockQuantity = blockLine * blockColumn;

		//カウンター1
		int counterOne;
		
		//カウンター2
		int counterTwo;
		
		//ブロックの番号
		int blockNumber;
		
		//段ごとのY座標
		int CoordinateY;

		//ブロック番号＝0
		blockNumber = 0;

		//ループ1
		for (counterOne = 0; counterOne < blockLine; counterOne++) {

			CoordinateY = counterOne * (blockHeight + 3) + blockMargin;

			//ループ2
			for (counterTwo = 0; counterTwo < blockColumn; counterTwo++) {

				blockX[blockNumber] = counterTwo * (blockWidth + 30) + blockMargin;

				blockY[blockNumber] = CoordinateY;

				blockExist[blockNumber] = 1;

				blockNumber++;

			}

		}

		//		for (countOne = 0; countOne < blockLine; countOne++) {
		//			CoordinateY = countOne * (blockHeight + 3) + blockMargin;
		//			for (countTwo = 0; countOne < blockColumn; countTwo++) {
		//				blockX[blockNumber] = countTwo * (blockWidth + 30) + blockMargin;
		//				blockY[blockNumber] = CoordinateY;
		//				blockExist[blockNumber] = 1;
		//				blockNumber++;
		//			}
		//
		//		}
	}

}
