package com.cyf.code.designPatterns.state;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午4:46 2018/9/20
 * @Desc ：
 */
public class RepeatVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		voteManager.getVoteMap().put(user, voteItem);
		System.out.println("重复投票，以最后以此为准！");
	}
}
