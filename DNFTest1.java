import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * 
 * @author whenguycan
 * @date 2018年11月24日 上午9:35:41
 */
public class DNFTest1 {

	public static void main(String[] args) {
		start();
	}

	static void start() {
		try {
			JFrame mainFrame = new JFrame();
			mainFrame.setBounds(200, 200, 800, 600);
			mainFrame.setBackground(Color.WHITE);

			JComponentManager.bind(mainFrame);

			mainFrame.addWindowListener(new WindowAdapter() {

				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			mainFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class JComponentManager {

		static Dimension dim = new Dimension(100, 25);
		static Point leftTop = new Point(0, 0);
		static Point left2Top = new Point(300, 0);
		static Point left3Top = new Point(0, 200);

		static void bind(JFrame mainFrame) {
			if (mainFrame == null)
				return;
			mainFrame.setLayout(null);

            JComboBox<String> comboJian = new JComboBox<>(new String[]{"Jian"});
            comboJian.setBounds(leftTop.x, leftTop.y, dim.width, dim.height);
            mainFrame.add(comboJian);

            JComboBox<String> comboTui = new JComboBox<>(new String[]{"Tui"});
            comboTui.setBounds(leftTop.x, leftTop.y + dim.height, dim.width, dim.height);
            mainFrame.add(comboTui);

            JComboBox<String> comboXie = new JComboBox<>(new String[]{"Xie"});
            comboXie.setBounds(leftTop.x, leftTop.y + dim.height * 2, dim.width, dim.height);
            mainFrame.add(comboXie);

            JComboBox<String> comboXiong = new JComboBox<>(new String[]{"Xiong"});
            comboXiong.setBounds(leftTop.x + dim.width, leftTop.y, dim.width, dim.height);
            mainFrame.add(comboXiong);

            JComboBox<String> comboYao = new JComboBox<>(new String[]{"Yao"});
            comboYao.setBounds(leftTop.x + dim.width, leftTop.y + dim.height, dim.width, dim.height);
            mainFrame.add(comboYao);

            JComboBox<String> comboWuQi = new JComboBox<>(new String[]{"WuQi"});
            comboWuQi.setBounds(left2Top.x, left2Top.y, dim.width, dim.height);
            mainFrame.add(comboWuQi);

            JComboBox<String> comboShouZhuo = new JComboBox<>(new String[]{"ShouZhuo"});
            comboShouZhuo.setBounds(left2Top.x, left2Top.y + dim.height, dim.width, dim.height);
            mainFrame.add(comboShouZhuo);

            JComboBox<String> comboFuZhu = new JComboBox<>(new String[]{"FuZhu"});
            comboFuZhu.setBounds(left2Top.x, left2Top.y + dim.height * 2, dim.width, dim.height);
            mainFrame.add(comboFuZhu);

            JComboBox<String> comboErHuan = new JComboBox<>(new String[]{"ErHuan"});
            comboErHuan.setBounds(left2Top.x, left2Top.y + dim.height * 3, dim.width, dim.height);
            mainFrame.add(comboErHuan);

            JComboBox<String> comboChengHao = new JComboBox<>(new String[]{"ChengHao"});
            comboChengHao.setBounds(left2Top.x + dim.width, left2Top.y, dim.width, dim.height);
            mainFrame.add(comboChengHao);

            JComboBox<String> comboXiangLian = new JComboBox<>(new String[]{"XiangLian"});
            comboXiangLian.setBounds(left2Top.x + dim.width, left2Top.y + dim.height, dim.width, dim.height);
            mainFrame.add(comboXiangLian);

            JComboBox<String> comboJieZhi = new JComboBox<>(new String[]{"JieZhi"});
            comboJieZhi.setBounds(left2Top.x + dim.width, left2Top.y + dim.height * 2, dim.width, dim.height);
            mainFrame.add(comboJieZhi);

            JComboBox<String> comboMoFaShi = new JComboBox<>(new String[]{"MoFaShi"});
            comboMoFaShi.setBounds(left2Top.x + dim.width, left2Top.y + dim.height * 3, dim.width, dim.height);
            mainFrame.add(comboMoFaShi);

            JTextField textBasic = new JTextField("111");
            textBasic.setBounds(left3Top.x, left3Top.y, dim.width, dim.height);
            textBasic.setEditable(false);
            textBasic.setHorizontalAlignment(JTextField.RIGHT);
            mainFrame.add(textBasic);

            JButton btnCalc = new JButton("Calc");
            btnCalc.setBounds(left3Top.x + dim.width, left3Top.y, dim.width, dim.height);
            mainFrame.add(btnCalc);

            JTextField textDamage = new JTextField();
            textDamage.setBounds(left3Top.x + dim.width * 2, left3Top.y, dim.width, dim.height);
            textDamage.setEditable(false);
            textDamage.setHorizontalAlignment(JTextField.RIGHT);
            mainFrame.add(textDamage);

            btnCalc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    GameRole gr = new GameRole("", 2000, 13, 1000);
                    int damage = calc(gr);
                    textDamage.setText("" + damage);
                }
            });
		}
	}

    static int calc(GameRole gr, Item... items) {
        int basic = 1;
        int damage = 0;

        return damage;
    }

    static class GameRole extends BaseAttrs {

	    public GameRole(String name, int inte, int attr, int inde) {
            this.name = name;
            this.inte = inte;
            this.attr = attr;
            this.inde = inde;
        }

    }

	enum ItemType {
        Jian, Xiong, Tui, Yao, Xie,
        WuQi, ChengHao,
        ShouZhuo, XiangLian, FuZhu, JieZhi, ErHuan, MoFaShi,
        TaoZhuang;
	}

	static Item[] getItemList(ItemType itemType){
        List<Item> list = new ArrayList<>();
        switch (itemType){
            case Jian:
                list.add(Items.MoZhanJian);
                break;
            default:
                break;
        }
        return list.toArray(new Item[list.size()]);
    }

    interface Items {
        Item MoZhanJian = new Item("", ItemType.Jian);
	    Item YaoDao = new Item("", ItemType.WuQi).inte(112).inde(1157).yellEx(35).thre(22);
    }

    interface Suits {
        Item MoZhan5 = new Item("", ItemType.TaoZhuang);
        Item WanShi3 = new Item("", ItemType.TaoZhuang);
        Item WanShi5 = new Item("", ItemType.TaoZhuang);
        Item HuangHu3 = new Item("", ItemType.TaoZhuang);
        Item HaiBoLun3JiGong = new Item("", ItemType.TaoZhuang);
        Item HaiBoLun3ShuBai = new Item("", ItemType.TaoZhuang);
    }

    static class Item extends BaseAttrs {

        ItemType itemType;

        public Item(String name, ItemType itemType) {
            this.name = name;
            this.itemType = itemType;
        }

        Item inte(int inte){
            this.inte = inte;
            return this;
        }

        Item attr(int attr){
            this.attr = attr;
            return this;
        }

        Item inde(int inde){
            this.inde = inde;
            return this;
        }

        Item yell(int yell){
            this.yell = yell;
            return this;
        }

        Item whit(int whit){
            this.whit = whit;
            return this;
        }

        Item crit(int crit){
            this.crit = crit;
            return this;
        }

        Item yellEx(int yellEx){
            this.yellEx = yellEx;
            return this;
        }

        Item whitEx(int whitEx){
            this.whitEx = whitEx;
            return this;
        }

        Item critEx(int critEx){
            this.critEx = critEx;
            return this;
        }

        Item thre(int thre){
            this.thre = thre;
            return this;
        }

        Item fina(int fina){
            this.fina = fina;
            return this;
        }

        Item skil(int skil){
            this.skil = skil;
            return this;
        }

        Item intePrec(int intePrec){
            this.intePrec = intePrec;
            return this;
        }

        public String toString() {
            return this.name;
        }
    }

    static class BaseAttrs {

        String name;
        int inte;
        int attr;
        int inde;

        int yell;
        int whit;
        int crit;
        int yellEx;
        int whitEx;
        int critEx;

        int thre;
        int fina;
        int skil;
        int intePrec;

    }

}