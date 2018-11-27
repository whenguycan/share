package proxy;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

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

	static class Role {

		static Role newInstance() {
			Role role = new Role();
			role.inte = 2000; // 智力
			role.attr = 13; // 基础属性强化
			role.inde = 1000; // 独立攻击力
			return role;
		}

		int inte;
		int attr;
		int inde;
	}

	static class XiuLuo extends Item {

	}

	static class Item {
		String name;
		ItemGroup eg;
		ItemType et;
		int inte;
		int intePerc;
		int yell;
		int whit;
		int crit;
		int yellEx;
		int critEx;
		int thre;
		int fina;
		int attr;
		int inde;

		Item group3;
		Item group5;

		static Item build(String name, ItemGroup itemGroup, ItemType itemType, Item group3, Item group5, int[] attrs) {
			Item item = new Item();
			item.name = name;
			item.eg = itemGroup;
			item.et = itemType;
			item.group3 = group3;
			item.group5 = group5;
			if (attrs != null && attrs.length == 11) {
				item.inte = attrs[0];
				item.intePerc = attrs[1];
				item.yell = attrs[2];
				item.whit = attrs[3];
				item.crit = attrs[4];
				item.yellEx = attrs[5];
				item.critEx = attrs[6];
				item.thre = attrs[7];
				item.fina = attrs[8];
				item.attr = attrs[9];
				item.inde = attrs[10];
			}
			return item;
		}

	}

	static enum ItemType {
		TouJian, ShangYi, XiaZhuang, YaoDai, Xie, WuQi, ChengHao, ShouZhuo, XiangLian, FuZhu, JieZhi, ErHuan, MoFaShi
	}

	static enum ItemGroup {
		MoZhan, WanShi, HuangHu, HaiBoLun;
	}

	static Item[] equipList(ItemType itemType) {
		List<Item> list = new ArrayList<>();
		switch (itemType) {
			case TouJian:
				list.add(Item.build("魔战肩", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
				list.add(Item.build("万世肩", ItemGroup.WanShi, ItemType.TouJian, null, null, new int[]{106, 0, 0, 0, 0, 0, 0, 0, 5, 22, 0}));
				break;
			case ShangYi:
				list.add(Item.build("魔战胸", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("万世胸", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case XiaZhuang:
				list.add(Item.build("魔战腿", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("万世腿", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case YaoDai:
				list.add(Item.build("魔战腰", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("万世腰", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case Xie:
				list.add(Item.build("魔战鞋", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("万世鞋", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case WuQi:
				list.add(Item.build("妖刀", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("暗影", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case ChengHao:
				list.add(Item.build("龙之挑战", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case ShouZhuo:
				list.add(Item.build("大无尽", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("启明星", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case XiangLian:
				list.add(Item.build("大无尽", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("氤氲", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case FuZhu:
				list.add(Item.build("假面", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("王冠非冠", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case JieZhi:
				list.add(Item.build("大无尽", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("清泉", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case ErHuan:
				list.add(Item.build("英雄王", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("黑暗祭礼", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			case MoFaShi:
				list.add(Item.build("黑白", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				list.add(Item.build("王座本源", ItemGroup.MoZhan, ItemType.TouJian, null, null, new int[]{}));
				break;
			default:
				break;
		}
		return list.toArray(new Item[list.size()]);
	}

	static class JComponentManager {

		static Dimension dim = new Dimension(100, 25);

		static void bind(JFrame mainFrame) {
			if (mainFrame == null)
				return;
			mainFrame.setLayout(null);

			JComboBox<Item> touJianSel = new JComboBox<>(equipList(ItemType.TouJian));
			touJianSel.setBounds(0, 0, dim.width, dim.height);

			mainFrame.add(touJianSel);
		}
	}

	static int calc(XiuLuo xiuLuo, Item... items) {
		int basic = 1;
		
		return basic;
	}

}
