package com.cyf.code.designPatterns.state;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午4:56 2018/9/20
 * @Desc ：
 */
public class BlackVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("已经被拉入黑名单");
	}
}
