package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import control.BlockControl;
import model.BlockBean;

/**
 * BlockView
 * 初期設定、表示情報設定
 * okd
 */
public class BlockView extends Frame implements ActionListener, MouseMotionListener {

	//クラス変数作成

	//ブロック崩しの描画領域
    BlockViewPanel blockViewPanel;

	//BlockViewPanel blockViewPanel = new BlockViewPanel();

	//ブロック崩し制御用スレッド
	BlockControl blockControl;

	//開始ボタン
	Button startButton;

	//終了ボタン
	Button endButton;

	//リプレイボタン
	Button replayButton;

	//画像情報クラス
	BlockBean blockBean = new BlockBean();

	//画像情報クラスのゲッター、セッター
	public BlockBean getBlockBean() {
		return blockBean;
	}

	public void setBlockBean(BlockBean blockBean) {
		this.blockBean = blockBean;
	}

	/**
	 * コンストラクタ開始 【Method】
	 */
	public BlockView() {

		//描画エリア、パネル設定
		blockViewPanel = new BlockViewPanel();
		blockViewPanel.setBackground(Color.black);
		blockViewPanel.setVisible(true);
		this.add(blockViewPanel);

		//ボタン設定
		startButton = new Button("開始");
		endButton = new Button("終了");
		replayButton = new Button("再開");
		this.add(startButton);
		this.add(endButton);
		this.add(replayButton);

		//リスナーとして登録設定
		startButton.addActionListener(this);
		endButton.addActionListener(this);
		replayButton.addActionListener(this);
		blockViewPanel.addMouseMotionListener(this);

		//下記の初期情報 呼び出し！
		startInformation();
	}

	/**
	 * 初期情報の設定 【Method】
	 */
	public void startInformation() {

		//画像情報のセット【ボール、ラケット、ブロック】
		blockBean.setBallImage(Toolkit.getDefaultToolkit().getImage("src/ball.jpg"));
		blockBean.setRacketImage(Toolkit.getDefaultToolkit().getImage("src/racket.jpg"));
		blockBean.setBlockImage(Toolkit.getDefaultToolkit().getImage("src/block.jpg"));

		//ボールの初期位置【x,y,座標セット】
		blockBean.setBallCenterX(10);
		blockBean.setBallCenterY(100);

		//ボールの【横幅、縦幅をセット】
		blockBean.setBallWidth(5);
		blockBean.setBallHeight(5);

		//【実行時間間隔をセット】
		blockBean.setRewriteTime(5);

		//【次のボールの増分量をセット（x座標、y座標）】
		blockBean.setBallNextX(2);
		blockBean.setBallNextY(2);

		//【ブロックの横幅、縦幅、間隔をセット】
		blockBean.setBlockWidth(50); //ブロックの横幅
		blockBean.setBlockHeight(20); //ブロックの高さ
		blockBean.setBlockMargin(10); //ブロックのマージン

		//【ブロックの行、列のセット】
		blockBean.setBlockLine(3); //ブロックの行
		blockBean.setBlockColumn(5); //ブロックの列
		blockBean.blockingset(); //ブロックの初期状態

		//【モードセット】
		blockBean.setStatus(0);

		/**
		 *【ブロック崩しのステータス】
		 * 0が初期状態
		 * 1が実行中
		 * 2がボールが下に行った時
		 * 3がブロックが無くなった時
		 */
	}

	/**
	 * ボタン、ラケット表示情報設定 【Method】
	 */
	public void displayInformation() {

		//ボタンの高さ
		int buttonHeight = 30;

		//見える領域の（インセット）の情報を取得
		Insets insets = this.getInsets();

		//領域幅
		int widthArea = this.getWidth() - insets.left - insets.right;

		//高さ領域
		int heightArea = this.getHeight() - insets.top - insets.bottom - buttonHeight;

		//インセットに合わせて描画エリアを配置

		blockViewPanel.setBounds(insets.left, insets.top, widthArea, heightArea);

		//ボタンの幅
		int buttonWidth = widthArea / 3;

		//ボタンx軸基準値
		int basisButtonX = insets.left;

		//ボタンy軸基準値
		int basisButtonY = this.getHeight() - insets.bottom - buttonHeight;

		//開始ボタン
		startButton.setBounds(basisButtonX, basisButtonY, buttonWidth, buttonHeight);

		//終了ボタン
		endButton.setBounds(basisButtonX + buttonWidth, basisButtonY, buttonWidth, buttonHeight);

		//再開ボタン
		replayButton.setBounds(basisButtonX + buttonWidth * 2, basisButtonY, buttonWidth, buttonHeight);

		//ラケットの幅と高さをセット
		blockBean.setRacketWidth(50);
		blockBean.setRacketHeight(10);

		//ラケットの位置情報をセット
		blockBean.setRacketX((widthArea - blockBean.getRacketWidth()) / 2);
		blockBean.setRacketY(widthArea - blockBean.getRacketHeight());

		//ブロック崩しの描画領域の幅と高さ情報をセット
		blockBean.setDrawingRangeWidth(blockViewPanel.getWidth());
		blockBean.setDrawingRangeHeight(heightArea);

	}

	/**
	 * ブロックが無くなったらゲーム終了 【Method】
	 */
	public void nonBlockGameEnd() {

		//初期設定 ブロック崩し制御用スレッド
		blockControl.interrupt();
	}

	/**
	 * 描画処理 【Method】
	 */
	public void drawingProcess(BlockBean blockBean) {

		//画像情報を渡して書き換えを指示
		blockViewPanel.screenRewrite(blockBean);
	}

	/**
	 * 開始ボタンが押された時 【Method】
	 */
	public void gameStart() {
		if (blockBean.getStatus() == 0) {
			blockBean.setStatus(1);
			blockControl = new BlockControl(this);
			blockControl.start();
		}
	}

	/**
	 * 終了ボタンが押された時 【Method】
	 */
	public void gameEnd() {

		System.exit(0);
	}

	/**
	 * 再開ボタンが押された時 【Method】
	 */
	public void gameRestart() {

		//条件②クリアした時か、ゲームオーバーの時だけ
		if (blockBean.getStatus() == 2 || blockBean.getStatus() == 3) {
			//初期設定
			startInformation();
			//開始ボタンが押された時
			gameStart();
		}
	}

	/**
	 * 配置ボタンの実行処理 【Method】
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		// 条件③	  開始ボタンが押された時
		if (actionEvent.getSource().equals(startButton)) {

			gameStart();

			// 条件④  終了ボタンが押された時
		} else if (actionEvent.getSource().equals(endButton)) {

			gameEnd();

			// 条件⑤ 再開ボタンが押された時
		} else if (actionEvent.getSource().equals(replayButton)) {

			gameRestart();
		}
	}

	/**
	 * マウスがドラッグされた処理 【Method】(空実装)
	 */
	@Override
	public void mouseDragged(MouseEvent mouseEvent) {

	}

	/**
	 * マウスが移動した処理 【Method】
	 */
	@Override
	public void mouseMoved(MouseEvent mouseEvent) {

		//マウスの位置
		int mousePosition;

		// 条件⑥
		if (mouseEvent.getX() + blockBean.getRacketWidth() > blockBean.getDrawingRangeWidth()) {

			//領域内に収まるよう計算
			mousePosition = mouseEvent.getX();
		}
		//マウス移動分をマウス位置保持にセット
		mousePosition = blockBean.getDrawingRangeWidth() - blockBean.getRacketWidth();

		//ラケットの座標セット
		blockBean.setRacketY(mousePosition);

		//描画処理
		drawingProcess(blockBean);

	}

}
