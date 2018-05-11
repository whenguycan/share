package com;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lepus
 * @date 2018-5-11 下午10:21:13
 */
public class RunesTest {

	public static void main(String[] args) {
		for (int i = 7; i > 2; i--) {
			System.out.println(i + "级：" + Pair.init(i, 0).weight());
		}
		listAll("堕天");
	}
	
	public static void listAll(String... includes){
		init();
		for (Rune rune : list) {
			if (includes != null && includes.length != 0) {
				boolean print = false;
				for (String name : includes) {
					if (name.equals(rune.name)) {
						print = true;
						break;
					}
				}
				if (print)
					rune.print();
			} else {
				rune.print();
			}
		}
	}

	public static List<Rune> list = new ArrayList<>();

	public static void init() {
		list.add(get("堕天", 1, 1, 1, 2, 0));
		list.add(get("统治", 1, 0, 0, 11, 6));
		list.add(get("死亡", 1, 0, 0, 7, 9));
		list.add(get("抵御", 0, 1, 2, 11, 11));
		list.add(get("恶魔", 1, 0, 1, 15, 8));
		list.add(get("宿命", 0, 0, 8, 14, 6));
		list.add(get("灼烧", 0, 0, 9, 19, 0));
		list.add(get("宝藏", 0, 0, 1, 2, 0));
		list.add(get("凛霜", 0, 0, 0, 3, 1));
		list.add(get("裁决", 0, 0, 0, 3, 0));
		list.add(get("法则", 0, 0, 1, 1, 1));
		list.add(get("魔法", 0, 0, 1, 2, 2));
		list.add(get("暴力", 0, 0, 1, 1, 2));
		list.add(get("天使", 1, 1, 0, 2, 1));
		list.add(get("王权", 1, 1, 3, 8, 1));
		list.add(get("安息", 1, 0, 0, 0, 7));
		list.add(get("守护", 0, 1, 3, 13, 11));
		list.add(get("魔鬼", 1, 0, 0, 4, 0));
		list.add(get("命运", 0, 0, 11, 13, 4));
		list.add(get("热诚", 0, 0, 11, 14, 0));
		list.add(get("圣杯", 0, 0, 1, 1, 0));
		list.add(get("冰霜", 0, 0, 1, 6, 0));
		list.add(get("审判", 0, 0, 1, 2, 0));
		list.add(get("正义", 0, 0, 0, 3, 0));
		list.add(get("圣言", 0, 0, 0, 2, 1));
		list.add(get("力量", 0, 0, 3, 0, 1));
	}

	public static Rune get(String name, int seven, int six, int five, int four, int three) {
		return Rune.init(name).add(Pair.init(7, seven)).add(Pair.init(6, six)).add(Pair.init(5, five))
				.add(Pair.init(4, four)).add(Pair.init(3, three));
	}

	static class Rune {
		String name;
		List<Pair> pairs;

		public static Rune init(String name) {
			Rune rune = new Rune();
			rune.name = name;
			rune.pairs = new ArrayList<>();
			return rune;
		}

		public Rune add(Pair pair) {
			pairs.add(pair);
			return this;
		}

		public void print() {
			int weight = 0;
			for (Pair p : pairs) {
				weight += p.weightAll();
			}
			System.out.println(name + ":" + weight);
		}
	}

	static class Pair {
		int level;
		int sum;

		public static Pair init(int level, int sum) {
			Pair pair = new Pair();
			pair.level = level;
			pair.sum = sum;
			return pair;
		}

		public int weight() {
			int weight = 1;
			if (level > 2) {
				for (int i = 3; i < level; i++) {
					weight *= 3;
				}
			}
			return weight;
		}

		public int weightAll() {
			return weight() * sum;
		}
	}

}
