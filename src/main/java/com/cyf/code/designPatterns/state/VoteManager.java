package com.cyf.code.designPatterns.state;

import java.util.*;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午4:19 2018/9/20
 * @Desc ：
 */
public class VoteManager {

	private VoteState voteState = null;

	private Map<String, String> voteMap = new HashMap<>();

	private Map<String, Integer> voteCountMap = new HashMap<>();


	public Map<String, String> getVoteMap() {
		return voteMap;
	}


	public void vote(String user, String voteItem) {
		Integer count = voteCountMap.get(user);
		if (count == null) {
			count = 0;
		}
		voteCountMap.put(user, ++count);

		if (count == 1) {
			voteState = new NormalVoteState();
		}
		if (count > 1 && count < 5) {
			voteState = new RepeatVoteState();

		} else if (count >= 5 && count < 8) {
			voteState = new SpiteVoteState();
		} else if (count >= 8) {
			voteState = new BlackVoteState();
		}
		voteState.vote(user, voteItem, this);
	}

	public static void main(String[] args) {

		List<Integer> num1 = new ArrayList<>();
		num1.add(1);
		num1.add(2);
		num1.add(3);
		List<Integer> num2 = num1;
		System.out.println("=====num1="+num1.hashCode());
		System.out.println("=====num2="+num2.hashCode());
		Map<Integer, String> map = new HashMap<>();
		map.put(1,"aa");
		map.put(2, "bb");
		map.put(3, "cc");
		for (Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator(); it.hasNext();){
			Map.Entry<Integer, String> item = it.next();
			if(item.getKey() == 2){
				map.remove(item.getKey());
			}
		}
		System.out.println("====="+map);
		num2.remove(0);
		num1.stream().forEach(n -> System.out.println("===="+n));

		VoteManager voteManager = new VoteManager();
		for (int i = 0; i < 10; i++) {
			voteManager.vote("leo", "Y");
		}
	}


}
