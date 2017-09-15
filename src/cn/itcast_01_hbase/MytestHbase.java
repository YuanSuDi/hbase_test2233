package cn.itcast_01_hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.junit.Before;

public class MytestHbase {
	
	/**
	 * 配置ss
	 */
	static Configuration config = null;
	private Connection connection = null;
	private Table table = null;
	
	@Before
	public void init() throws IOException{
		config =HBaseConfiguration.create();
		config.set("hbase.zookeeper.quorum","mini1,mini2,mini3");//zookeeper的集群地址
		config.set("hbase.zookeeper.property.clientPort", "2181");// zookeeper端口
		connection = ConnectionFactory.createConnection(config);
		connection.getTable(TableName.valueOf("user"));
	}
	
	
	
}
