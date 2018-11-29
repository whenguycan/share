import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFrame;

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

			JComponentManager.bind(mainFrame);

			mainFrame.addWindowListener(new WindowAdapter() {

				public void windowClosing(WindowEvent e) {
					super.windowClosing(e);
				}
			});
			mainFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class JComponentManager {

		static Dimension dim = new Dimension(100, 25);

		static void bind(JFrame mainFrame) {
			if (mainFrame == null)
				return;
			mainFrame.setLayout(null);

			JComboBox<Item> touJianSel = new JComboBox<>(getItemList(ItemType.TouJian));
			touJianSel.setBounds(0, 0, dim.width, dim.height);

			mainFrame.add(touJianSel);
		}
	}

	static int calc(Role role, Item... items) {
		int basic = 1;

		return basic;
	}

	enum ItemType {
		TouJian, ShangYi, XiaZhuang, YaoDai, Xie, WuQi, ChengHao, ShouZhuo, XiangLian, FuZhu, JieZhi, ErHuan, MoFaShi
	}

	enum ItemSuit {
		MoZhan, WanShi, HuangHu, HaiBoLun;
	}

	static class BaseAttrs {
		String name;
		int inte;
		int intePerc;
		int yell;
		int whit;
		int crit;
		int yellEx;
		int critEx;
		int thre;
		int fina;
		int skil;
		int attr;
		int inde;
		public BaseAttrs() {

		}
		public BaseAttrs(String name) {
			this.name = name;
		}
		BaseAttrs load(String info) {
			if(info == null)
				throw new RuntimeException("info is null");
			String[] arr = info.split("-");
			if(arr.length != 12)
				throw new RuntimeException("arr length is not 12");
			this.inte = Integer.parseInt(arr[0]);
			this.intePerc = Integer.parseInt(arr[1]);
			this.yell = Integer.parseInt(arr[2]);
			this.whit = Integer.parseInt(arr[3]);
			this.crit = Integer.parseInt(arr[4]);
			this.yellEx = Integer.parseInt(arr[5]);
			this.critEx = Integer.parseInt(arr[6]);
			this.thre = Integer.parseInt(arr[7]);
			this.fina = Integer.parseInt(arr[8]);
			this.skil = Integer.parseInt(arr[9]);
			this.attr = Integer.parseInt(arr[10]);
			this.inde = Integer.parseInt(arr[11]);
			return this;
		}
	}

	static class Role extends BaseAttrs {
		static Role XiuLuo;
		static {
			XiuLuo = (Role) new BaseAttrs("修罗").load(Infos.XiuLuo);
		}
	}

	static class Infos {
		static String XiuLuo = "";
		static String MoZhan5 = "";
		static String WanShi3 = "";
		static String WanShi5 = "";
		static String HuangHu3 = "";
		static String HaiBoLun3 = "";
		static String MoZhanJian = "";
		static String WanShiJian = "";
		static String MoZhanShangYi = "";
		static String WanShiShangYi = "";
		static String MoZhanXiaZhuang = "";
		static String WanShiXiaZhuang = "";
		static String MoZhanYaoDai = "";
		static String WanShiYaoDai = "";
		static String MoZhanXie = "";
		static String WanShiXie = "";
		static String YaoDao = "";
		static String AnYing = "";
		static String LongZhiTiaoZhan = "";
		static String WuJinShouZhuo = "";
		static String QiMingXing = "";
		static String WuJinXiangLian = "";
		static String YinYun = "";
		static String HeiBaiJiaMian = "";
		static String WangGuanFeiGuan = "";
		static String WuJinJieZhi = "";
		static String QingQuan = "";
		static String YingXiongWang = "";
		static String HeiAnJiLi = "";
		static String HeiBaiLingHun = "";
		static String WangZuoBenYuan = "";
	}

	static class Item extends BaseAttrs {

		ItemType itemType;
		ItemSuit itemSuit;

		public static Item build(String name, ItemType itemType, ItemSuit itemSuit){
			Item item = new Item();
			item.name = name;
			item.itemType = itemType;
			item.itemSuit = itemSuit;
			return item;
		}

	}

	static Map<String, BaseAttrs> getSuitMap (){
		Map<String, BaseAttrs> map = new HashMap<>();
		map.put(ItemSuit.MoZhan.name() + "5", new BaseAttrs("魔战5").load(Infos.MoZhan5));
		map.put(ItemSuit.WanShi.name() + "3", new BaseAttrs("万世3").load(Infos.WanShi3));
		map.put(ItemSuit.WanShi.name() + "5", new BaseAttrs("万世5").load(Infos.WanShi5));
		map.put(ItemSuit.HuangHu.name() + "3", new BaseAttrs("恍惚3").load(Infos.HuangHu3));
		map.put(ItemSuit.HaiBoLun.name() + "3", new BaseAttrs("海伯伦3").load(Infos.HaiBoLun3));
		return map;
	}

	static Item[] getItemList(ItemType itemType) {
		List<Item> list = new ArrayList<>();

		switch (itemType) {
			case TouJian:
				list.add(Item.build("魔战肩", ItemType.TouJian, ItemSuit.MoZhan).attrs(34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("万世肩", ItemType.TouJian, ItemSuit.WanShi).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case ShangYi:
				list.add(Item.build("魔战胸", ItemType.ShangYi, ItemSuit.MoZhan).attrs(43, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("万世胸", ItemType.ShangYi, ItemSuit.WanShi).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case XiaZhuang:
				list.add(Item.build("魔战腿", ItemType.XiaZhuang, ItemSuit.MoZhan).attrs(43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("万世腿", ItemType.XiaZhuang, ItemSuit.WanShi).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case YaoDai:
				list.add(Item.build("魔战腰", ItemType.YaoDai, ItemSuit.MoZhan).attrs(25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("万世腰", ItemType.YaoDai, ItemSuit.WanShi).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case Xie:
				list.add(Item.build("魔战鞋", ItemType.Xie, ItemSuit.MoZhan).attrs(113, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0));
				list.add(Item.build("万世鞋", ItemType.Xie, ItemSuit.WanShi).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case WuQi:
				list.add(Item.build("妖刀", ItemType.WuQi, null).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("暗影", ItemType.WuQi, null).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case ChengHao:
				list.add(Item.build("龙之挑战", ItemType.ChengHao, null).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case ShouZhuo:
				list.add(Item.build("大无尽", ItemType.ShouZhuo, null).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("启明星", ItemType.ShouZhuo, ItemSuit.HuangHu).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case XiangLian:
				list.add(Item.build("大无尽", ItemType.XiangLian, null).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("氤氲", ItemType.XiangLian, ItemSuit.HuangHu).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case FuZhu:
				list.add(Item.build("假面", ItemType.TouJian, null).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("王冠非冠", ItemType.TouJian, ItemSuit.HaiBoLun).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case JieZhi:
				list.add(Item.build("大无尽", ItemType.TouJian, null).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("清泉", ItemType.TouJian, ItemSuit.HuangHu).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case ErHuan:
				list.add(Item.build("英雄王", ItemType.TouJian, null).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("黑暗祭礼", ItemType.TouJian, ItemSuit.HaiBoLun).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			case MoFaShi:
				list.add(Item.build("黑白", ItemType.TouJian, null).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				list.add(Item.build("王座本源", ItemType.TouJian, ItemSuit.HaiBoLun).attrs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
				break;
			default:
				break;
		}
		return list.toArray(new Item[list.size()]);
	}

}
