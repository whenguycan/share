import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
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
		static Point left3Top = new Point(600, 0);
		static Point left4Top = new Point(0, 200);

		static void bind(JFrame mainFrame) {
			if (mainFrame == null)
				return;
			mainFrame.setLayout(null);

            JComboBox<Item> comboJian = new JComboBox<>(new Item[]{Items.MoZhanJian, Items.WanShiJian});
            comboJian.setBounds(leftTop.x, leftTop.y, dim.width, dim.height);
            mainFrame.add(comboJian);

            JComboBox<Item> comboTui = new JComboBox<>(new Item[]{Items.MoZhanTui});
            comboTui.setBounds(leftTop.x, leftTop.y + dim.height, dim.width, dim.height);
            mainFrame.add(comboTui);

            JComboBox<Item> comboXie = new JComboBox<>(new Item[]{Items.MoZhanXie, Items.WanShiXie});
            comboXie.setBounds(leftTop.x, leftTop.y + dim.height * 2, dim.width, dim.height);
            mainFrame.add(comboXie);

            JComboBox<Item> comboXiong = new JComboBox<>(new Item[]{Items.MoZhanXiong});
            comboXiong.setBounds(leftTop.x + dim.width, leftTop.y, dim.width, dim.height);
            mainFrame.add(comboXiong);

            JComboBox<Item> comboYao = new JComboBox<>(new Item[]{Items.MoZhanYao, Items.WanShiYao});
            comboYao.setBounds(leftTop.x + dim.width, leftTop.y + dim.height, dim.width, dim.height);
            mainFrame.add(comboYao);

            JComboBox<Item> comboWuQi = new JComboBox<>(new Item[]{Items.YaoDao});
            comboWuQi.setBounds(left2Top.x, left2Top.y, dim.width, dim.height);
            mainFrame.add(comboWuQi);

            JComboBox<Item> comboShouZhuo = new JComboBox<>(new Item[]{Items.WuJinShouZhuo});
            comboShouZhuo.setBounds(left2Top.x, left2Top.y + dim.height, dim.width, dim.height);
            mainFrame.add(comboShouZhuo);

            JComboBox<Item> comboFuZhu = new JComboBox<>(new Item[]{Items.JiaMian, Items.WangGuan});
            comboFuZhu.setBounds(left2Top.x, left2Top.y + dim.height * 2, dim.width, dim.height);
            mainFrame.add(comboFuZhu);

            JComboBox<Item> comboErHuan = new JComboBox<>(new Item[]{Items.SanSheng, Items.HeiAn});
            comboErHuan.setBounds(left2Top.x, left2Top.y + dim.height * 3, dim.width, dim.height);
            mainFrame.add(comboErHuan);

            JComboBox<Item> comboChengHao = new JComboBox<>(new Item[]{Items.LongTiaoZhan});
            comboChengHao.setBounds(left2Top.x + dim.width, left2Top.y, dim.width, dim.height);
            mainFrame.add(comboChengHao);

            JComboBox<Item> comboXiangLian = new JComboBox<>(new Item[]{Items.YinYun});
            comboXiangLian.setBounds(left2Top.x + dim.width, left2Top.y + dim.height, dim.width, dim.height);
            mainFrame.add(comboXiangLian);

            JComboBox<Item> comboJieZhi = new JComboBox<>(new Item[]{Items.WuJinJieZhi});
            comboJieZhi.setBounds(left2Top.x + dim.width, left2Top.y + dim.height * 2, dim.width, dim.height);
            mainFrame.add(comboJieZhi);

            JComboBox<Item> comboMoFaShi = new JComboBox<>(new Item[]{Items.LingHun, Items.WangZuo});
            comboMoFaShi.setBounds(left2Top.x + dim.width, left2Top.y + dim.height * 3, dim.width, dim.height);
            mainFrame.add(comboMoFaShi);

            JComboBox<Item> comboSuit1 = new JComboBox<>(new Item[]{Item.NONE, Suits.MoZhan5});
            comboSuit1.setBounds(left3Top.x, left3Top.y, dim.width, dim.height);
            mainFrame.add(comboSuit1);

            JComboBox<Item> comboSuit2 = new JComboBox<>(new Item[]{Item.NONE, Suits.WanShi3});
            comboSuit2.setBounds(left3Top.x, left3Top.y + dim.height, dim.width, dim.height);
            mainFrame.add(comboSuit2);

            JComboBox<Item> comboSuit3 = new JComboBox<>(new Item[]{});
            comboSuit3.setBounds(left3Top.x, left3Top.y + dim.height * 2, dim.width, dim.height);
            mainFrame.add(comboSuit3);

            JTextField textBasic = new JTextField("1");
            textBasic.setBounds(left4Top.x, left4Top.y, dim.width, dim.height);
            textBasic.setEditable(false);
            textBasic.setHorizontalAlignment(JTextField.RIGHT);
            mainFrame.add(textBasic);

            JButton btnCalc = new JButton("Calc");
            btnCalc.setBounds(left4Top.x + dim.width, left4Top.y, dim.width, dim.height);
            mainFrame.add(btnCalc);

            JTextField textDamage = new JTextField();
            textDamage.setBounds(left4Top.x + dim.width * 2, left4Top.y, dim.width, dim.height);
            textDamage.setEditable(false);
            textDamage.setHorizontalAlignment(JTextField.RIGHT);
            mainFrame.add(textDamage);

            btnCalc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    GameRole gr = new GameRole("", 1455, 13, 990);
                    Item jian = (Item) comboJian.getSelectedItem();
                    Item xiong = (Item) comboXiong.getSelectedItem();
                    Item tui = (Item) comboTui.getSelectedItem();
                    Item yao = (Item) comboYao.getSelectedItem();
                    Item xie = (Item) comboXie.getSelectedItem();
                    Item wuqi = (Item) comboWuQi.getSelectedItem();
                    Item chenghao = (Item) comboChengHao.getSelectedItem();
                    Item shouzhuo = (Item) comboShouZhuo.getSelectedItem();
                    Item xianglian = (Item) comboXiangLian.getSelectedItem();
                    Item fuzhu = (Item) comboFuZhu.getSelectedItem();
                    Item jiezhi = (Item) comboJieZhi.getSelectedItem();
                    Item erhuan = (Item) comboErHuan.getSelectedItem();
                    Item mofashi = (Item) comboMoFaShi.getSelectedItem();
                    Item suit1 = (Item) comboSuit1.getSelectedItem();
                    Item suit2 = (Item) comboSuit2.getSelectedItem();
                    Item suit3 = (Item) comboSuit3.getSelectedItem();
                    List<Item> suits = new ArrayList<>();
                    if(suit1 != null)
                        suits.add(suit1);
                    if(suit2 != null)
                        suits.add(suit2);
                    if(suit3 != null)
                        suits.add(suit3);
                    String damage = calc(gr, suits, jian, xiong, tui, yao, xie, wuqi, chenghao, shouzhuo, xianglian, fuzhu, jiezhi, erhuan, mofashi);
                    textDamage.setText(damage);
                }
            });
		}
	}

    static String calc(GameRole gr, List<Item> suits, Item... items) {
        List<Integer> skils = new ArrayList<>();
        List<Item> all = new ArrayList<>(Arrays.asList(items));
        if(suits != null && !suits.isEmpty()) {
            all.addAll(suits);
        }
        for(Item item : all){
            gr.inte += item.inte;
            gr.attr += item.attr;
            gr.inde += item.inde;
            gr.yell = item.yell > gr.yell ? item.yell : gr.yell;
            gr.whit += item.whit;
            gr.crit = item.crit > gr.crit ? item.crit : gr.crit;
            gr.yellEx += item.yellEx;
            gr.whitEx += item.whitEx;
            gr.critEx += item.critEx;
            gr.thre += item.thre;
            gr.fina += item.fina;
            if(item.skil != 0)
                skils.add(item.skil);
            gr.intePrec += item.intePrec;
        }
        double damage = 1d;
        damage *= 1 + 0.004d * gr.inte * (1 + 0.01d * gr.intePrec);
        damage *= 1 + gr.attr / 220d;
        damage *= 1 + 0.001 * (gr.inde * (1 + 0.01d * gr.thre) - 1000);
        damage *= 1 + 0.01d * (gr.yell + gr.yellEx);
        damage *= 1 + 0.01d * (gr.crit + gr.critEx);
        damage *= 1 + 0.01d * (gr.whit + gr.whitEx * (1 + 100/ 220d * gr.attr));
        damage *= 1 + 0.01d * gr.fina;
        if(!skils.isEmpty()){
            for(int i : skils){
                damage *= 1 + 0.01d * i;
            }
        }
        return String.format("%.2f", damage);
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
        Suit;
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
	    Item YaoDao = new Item("妖刀", ItemType.WuQi).inte(110).inde(1138).yellEx(35).thre(22);
        Item LongTiaoZhan = new Item("龙挑战", ItemType.ChengHao).inde(50).inte(60).attr(15).whit(10);
        Item WuJinShouZhuo = new Item("无尽手镯", ItemType.ShouZhuo).yell(30);
        Item YinYun = new Item("氤氲", ItemType.XiangLian).inte(41).fina(15);
        Item WuJinJieZhi = new Item("无尽戒指", ItemType.JieZhi).inte(56).crit(30);
        Item MoZhanXie = new Item("魔战鞋", ItemType.Xie).inte(109).thre(8);
        Item MoZhanTui = new Item("魔战腿", ItemType.Tui).inte(39);
        Item MoZhanJian = new Item("魔战肩", ItemType.Jian).inte(31);
        Item MoZhanXiong = new Item("魔战胸", ItemType.Xiong).inte(39).yell(10);
        Item MoZhanYao = new Item("魔战腰", ItemType.Yao).inte(25);
        Item WanShiXie = new Item("万世鞋", ItemType.Xie).inte(97).attr(21).intePrec(5);
        Item WanShiJian = new Item("万世肩", ItemType.Jian).inte(103).attr(21).fina(5);
        Item WanShiYao = new Item("万世腰", ItemType.Yao).inte(97).attr(22).thre(5);
        Item SanSheng = new Item("三生", ItemType.ErHuan).inte(62).inde(187).critEx(8);
        Item LingHun = new Item("灵魂", ItemType.MoFaShi).inte(59).attr(55);
        Item JiaMian = new Item("假面", ItemType.FuZhu).inte(41).thre(7).intePrec(7);
        Item HeiAn = new Item("黑暗", ItemType.ErHuan).inte(118).thre(22);
        Item WangGuan = new Item("王冠", ItemType.FuZhu).inte(124).fina(20);
        Item WangZuo = new Item("王座", ItemType.MoFaShi).inte(63).skil(10);
	}

    interface Suits {
        Item MoZhan5 = new Item("魔战5", ItemType.Suit).whit(35);
        Item WanShi3 = new Item("万世3", ItemType.Suit).attr(25).whit(15);
        Item WanShi5 = new Item("万世5", ItemType.Suit);
        Item HuangHu3 = new Item("恍惚", ItemType.Suit).yell(20).crit(20);
        Item HaiBoLunGuang = new Item("海伯伦光", ItemType.Suit).inte(200).whitEx(15);
        Item HaiBoLunAn = new Item("海伯伦暗", ItemType.Suit).inte(200).skil(20);
    }

    static class Item extends BaseAttrs {

	    static Item NONE = new Item("无", ItemType.Suit);

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