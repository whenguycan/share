package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author whenguycan
 * @date 2018年4月25日 上午8:36:02
 */
public class CangTest2 {

	public static void main(String[] args){
		Data data = new Data();
//		print(data.count(0, null));
		print(data, "莉可丽丝");
		print(data, "菲娅");
		print(data, "齐格飞");
		print(data, "特斯拉");
//		print(data, "美杜莎");
//		print(data, "伊莎贝拉");
//		print(data, "杰克");
		
		// 1.4 3.1 5.2 2.4 6.2
		
	}
	
	public static void print(Data data, String name){
		print(data.count(1, name));
		print(data.find(2, name));
	}
	
	public static void print(List<String> list){
		list.stream().forEach(line -> {
			System.out.println(line);
		});
	}

	static class Data {

		List<String> list = new ArrayList<>();

		// count in 0, 1
		public List<String> count(int count, String key){

			Map<String, Integer> map = new HashMap<>();
			List<String> find = new ArrayList<>();

			list.stream().forEach(line -> {
				String[] arr = line.split("_");
				if(arr.length > 2){
					String[] names = arr[2].split("\\+");
					Arrays.asList(names).stream().forEach(name -> {
						if (count == 0 || (count == 1 && name.equals(key))) {
							map.put(name, 0);
						}
					});
				}
			});
			
			map.keySet().stream().forEach(name -> {
				List<String> l = find(2, name);
				find.add(name + "_" + l.size());
			});

			return find;

		}

		// pos in -1, 0, 1, 2
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

			return find;
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
			add("4.暮光城_4.3_美杜莎+潘多拉+薇薇安");
			add("4.暮光城_4.4_杰克+潘多拉+罗兰");
			add("4.暮光城_4.5_桑尼+罗兰+尼尔法");
			add("5.曼彻斯特_5.1_哥伦布+珊朵拉+罗兰");
			add("5.曼彻斯特_5.2_莉可丽丝+尼尔法+罗兰");
			add("5.曼彻斯特_5.3_珊朵拉+尼尔法+格莱明");
			add("5.曼彻斯特_5.4_薇薇安+潘朵拉+罗兰");
			add("5.曼彻斯特_5.5_卡缇+杰克+瓦恩");
			add("6.温泉谷_6.1_格莱明+尼尔法+路西菲尔");
			add("6.温泉谷_6.2_齐格飞+哥伦布+路西菲尔");
			add("6.温泉谷_6.3_路西菲尔+哥伦布+薇薇安");
		}

		List<String> add(String value){
			list.add(value);
			return list;
		}
	}

}
