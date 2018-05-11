package com;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author whenguycan
 * @date 2018年4月25日 上午8:36:02
 */
public class CangTest2 {

	public static void main(String[] args){
		Data data = new Data();
		data.find(2, "莉可丽丝");
//		data.find(2, "薇薇安");
	}

	static class Data {

		List<String> list = new ArrayList<>();

		public List<String> find(int pos, String key){

			List<String> find = new ArrayList<>();
			
			if (pos == -1) {
				find.addAll(list);
			} else {
				list.stream().forEach(line -> {
					String[] arr = line.split("_");
					if (pos < arr.length && arr[pos].contains(key)) {
						find.add(line);
					}
				});
			}

			find.stream().forEach(line -> {
				System.out.println(line);
			});

			return list;
		}

		public Data(){
			add("1.弥赛亚_1.1_杰克+珊朵拉+潘多拉");
			add("1.弥赛亚_1.2_桑尼+罗兰+尼尔法");
			add("1.弥赛亚_1.3_哥伦布+珊朵拉+罗兰");
			add("1.弥赛亚_1.4_莉可丽丝+尼尔法+罗兰");
			add("1.弥赛亚_1.5_珊朵拉+尼尔法+格莱明");
			add("2.赛连_2.1_薇薇安+潘多拉+罗兰");
			add("2.赛连_2.2_卡缇+杰克+瓦恩");
			add("2.赛连_2.3_格莱明+尼尔法+路西菲尔");
			add("2.赛连_2.4_齐格飞+哥伦布+路西菲尔");
			add("2.赛连_2.5_路西菲尔+哥伦布+薇薇安");
			add("3.沃尔达_3.1_黛丝+桑尼+莉可丽丝");
			add("3.沃尔达_3.2_薛定谔+潘多拉+珊朵拉");
			add("3.沃尔达_3.3_");
			add("3.沃尔达_3.4_尼尔法+罗兰+哥伦布");
			add("3.沃尔达_3.5_伊莎贝拉+尼尔法+黛丝");
			add("4.暮光城_4.1_特斯拉+格莱明+珊朵拉");
			add("4.暮光城_4.2_菲娅+薛定谔+薇薇安");
		}

		List<String> add(String value){
			list.add(value);
			return list;
		}
	}

}
