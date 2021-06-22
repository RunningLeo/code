package com.cyf.code.designPatterns.state;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午4:16 2018/9/20
 * @Desc ：
 */
public interface VoteState {

	/**
	 * 投票的方法
	 * @param user
	 * @param voteItem
	 * @param voteManager
	 */
   public void vote(String user, String voteItem, VoteManager voteManager);
}
