package com.cyf.code.designPatterns.state;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午4:53 2018/9/20
 * @Desc ：
 */
public class SpiteVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {

		String voteInfo = voteManager.getVoteMap().get(user);
		if(voteInfo != null){
			voteManager.getVoteMap().remove(user);
		}
		System.out.println("存在恶意刷票，取消资格");
	}
}
