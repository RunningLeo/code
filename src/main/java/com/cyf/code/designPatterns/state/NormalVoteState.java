package com.cyf.code.designPatterns.state;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午4:18 2018/9/20
 * @Desc ：正常的投票
 */
public class NormalVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {

		//正常的投票
        voteManager.getVoteMap().put(user, voteItem);
		System.out.println("投票成功！");
	}
}
