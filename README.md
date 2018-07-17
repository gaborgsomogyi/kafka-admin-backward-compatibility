### Introduction
Simple Kafka `AdminClient` backward compatibility tester. It contains an old broker and a new client application.

`listOffsets` API blows up with the following exception with `0.10.x` brokers:
```
Exception in thread "main" java.util.concurrent.ExecutionException: org.apache.kafka.common.errors.UnsupportedVersionException: MetadataRequest versions older than 4 don't support the allowAutoTopicCreation field
```
The reason behind is [KAFKA-5291](https://issues.apache.org/jira/browse/KAFKA-5291).
As a conclusion `0.11.0.0+` Kafka brokers are compatible with `2.6.0` `AdminClient`.

### Build the app
To build, you need Scala 2.11 and 2.12, git and maven on the box.
Do a git clone of this repo and then run:
```
cd kafka-admin-backward-compatibility
mvn clean package
```

### Running kafka-broker app
```
java -jar kafka-broker/target/kafka-broker-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

### Running kafka-client app
```
java -jar kafka-client/target/kafka-client-0.0.1-SNAPSHOT-jar-with-dependencies.jar 127.0.0.1:broker-port
```

### What you should see

## kafka-broker
```
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:zookeeper.version=3.4.10-39d3a4f269333c922ed3db283be479f9deacaa0f, built on 03/23/2017 10:13 GMT
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:host.name=example.com
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:java.version=1.8.0_265
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:java.vendor=AdoptOpenJDK
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:java.home=/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:java.class.path=kafka-broker/target/kafka-broker-0.0.1-SNAPSHOT-jar-with-dependencies.jar
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:java.library.path=/Users/gaborsomogyi/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:java.io.tmpdir=/var/folders/jd/35_sh46s7zq0qc6khfw8hc800000gn/T/
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:java.compiler=<NA>
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:os.name=Mac OS X
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:os.arch=x86_64
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:os.version=10.15.3
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:user.name=gaborsomogyi
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:user.home=/Users/gaborsomogyi
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Server environment:user.dir=/Users/gaborsomogyi/kafka-admin-backward-compatibility
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Created server with tickTime 500 minSessionTimeout 1000 maxSessionTimeout 10000 datadir /private/var/folders/jd/35_sh46s7zq0qc6khfw8hc800000gn/T/spark-d37d1f12-200a-44ae-9380-74dccf359545/version-2 snapdir /private/var/folders/jd/35_sh46s7zq0qc6khfw8hc800000gn/T/spark-4520f460-8c86-42d3-9344-acbab40760c9/version-2
>>> 20/10/20 12:11:50 INFO server.NIOServerCnxnFactory: binding to port /127.0.0.1:0
>>> 20/10/20 12:11:50 ERROR server.ZooKeeperServer: ZKShutdownHandler is not registered, so ZooKeeper server won't take any action on ERROR or SHUTDOWN server state changes
>>> 20/10/20 12:11:50 INFO server.KafkaServer: starting
>>> 20/10/20 12:11:50 INFO server.KafkaServer: Connecting to zookeeper on 127.0.0.1:64270
>>> 20/10/20 12:11:50 INFO zkclient.ZkEventThread: Starting ZkClient event thread.
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:zookeeper.version=3.4.10-39d3a4f269333c922ed3db283be479f9deacaa0f, built on 03/23/2017 10:13 GMT
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:host.name=example.com
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:java.version=1.8.0_265
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:java.vendor=AdoptOpenJDK
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:java.home=/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/jre
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:java.class.path=kafka-broker/target/kafka-broker-0.0.1-SNAPSHOT-jar-with-dependencies.jar
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:java.library.path=/Users/gaborsomogyi/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:java.io.tmpdir=/var/folders/jd/35_sh46s7zq0qc6khfw8hc800000gn/T/
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:java.compiler=<NA>
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:os.name=Mac OS X
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:os.arch=x86_64
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:os.version=10.15.3
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:user.name=gaborsomogyi
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:user.home=/Users/gaborsomogyi
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Client environment:user.dir=/Users/gaborsomogyi/kafka-admin-backward-compatibility
>>> 20/10/20 12:11:50 INFO zookeeper.ZooKeeper: Initiating client connection, connectString=127.0.0.1:64270 sessionTimeout=6000 watcher=org.I0Itec.zkclient.ZkClient@363ee3a2
>>> 20/10/20 12:11:50 INFO zkclient.ZkClient: Waiting for keeper state SyncConnected
>>> 20/10/20 12:11:50 INFO zookeeper.ClientCnxn: Opening socket connection to server 127.0.0.1/127.0.0.1:64270. Will not attempt to authenticate using SASL (unknown error)
>>> 20/10/20 12:11:50 INFO zookeeper.ClientCnxn: Socket connection established to 127.0.0.1/127.0.0.1:64270, initiating session
>>> 20/10/20 12:11:50 INFO server.NIOServerCnxnFactory: Accepted socket connection from /127.0.0.1:64271
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Client attempting to establish new session at /127.0.0.1:64271
>>> 20/10/20 12:11:50 INFO persistence.FileTxnLog: Creating new log file: log.1
>>> 20/10/20 12:11:50 INFO server.ZooKeeperServer: Established session 0x175457e5b230000 with negotiated timeout 6000 for client /127.0.0.1:64271
>>> 20/10/20 12:11:50 INFO zookeeper.ClientCnxn: Session establishment complete on server 127.0.0.1/127.0.0.1:64270, sessionid = 0x175457e5b230000, negotiated timeout = 6000
>>> 20/10/20 12:11:50 INFO zkclient.ZkClient: zookeeper state changed (SyncConnected)
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:create cxid:0x5 zxid:0x3 txntype:-1 reqpath:n/a Error Path:/brokers Error:KeeperErrorCode = NoNode for /brokers
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:create cxid:0xb zxid:0x7 txntype:-1 reqpath:n/a Error Path:/config Error:KeeperErrorCode = NoNode for /config
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:create cxid:0x13 zxid:0xc txntype:-1 reqpath:n/a Error Path:/admin Error:KeeperErrorCode = NoNode for /admin
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:create cxid:0x1d zxid:0x12 txntype:-1 reqpath:n/a Error Path:/cluster Error:KeeperErrorCode = NoNode for /cluster
>>> 20/10/20 12:11:50 INFO server.KafkaServer: Cluster ID = IUDe7i4dRdOxmEqJhJjEQg
>>> 20/10/20 12:11:50 WARN server.BrokerMetadataCheckpoint: No meta.properties file under dir /private/var/folders/jd/35_sh46s7zq0qc6khfw8hc800000gn/T/spark-a450b5f8-3645-4cbe-8b66-042d37b080a6/meta.properties
>>> 20/10/20 12:11:50 INFO server.ClientQuotaManager$ThrottledRequestReaper: [ThrottledRequestReaper-Fetch]: Starting
>>> 20/10/20 12:11:50 INFO server.ClientQuotaManager$ThrottledRequestReaper: [ThrottledRequestReaper-Produce]: Starting
>>> 20/10/20 12:11:50 INFO server.ClientQuotaManager$ThrottledRequestReaper: [ThrottledRequestReaper-Request]: Starting
>>> 20/10/20 12:11:50 INFO log.LogManager: Loading logs.
>>> 20/10/20 12:11:50 INFO log.LogManager: Logs loading complete in 4 ms.
>>> 20/10/20 12:11:50 INFO log.LogManager: Starting log cleanup with a period of 300000 ms.
>>> 20/10/20 12:11:50 INFO log.LogManager: Starting log flusher with a default period of 9223372036854775807 ms.
>>> 20/10/20 12:11:50 INFO log.LogCleaner: Starting the log cleaner
>>> 20/10/20 12:11:50 INFO log.LogCleaner: [kafka-log-cleaner-thread-0]: Starting
>>> 20/10/20 12:11:50 INFO network.Acceptor: Awaiting socket connections on 127.0.0.1:64272.
>>> 20/10/20 12:11:50 INFO network.SocketServer: [Socket Server on Broker 0], Started 1 acceptor threads
>>> 20/10/20 12:11:50 INFO server.DelayedOperationPurgatory$ExpiredOperationReaper: [ExpirationReaper-0-Produce]: Starting
>>> 20/10/20 12:11:50 INFO server.DelayedOperationPurgatory$ExpiredOperationReaper: [ExpirationReaper-0-Fetch]: Starting
>>> 20/10/20 12:11:50 INFO server.DelayedOperationPurgatory$ExpiredOperationReaper: [ExpirationReaper-0-DeleteRecords]: Starting
>>> 20/10/20 12:11:50 INFO controller.ControllerEventManager$ControllerEventThread: [controller-event-thread]: Starting
>>> 20/10/20 12:11:50 INFO server.DelayedOperationPurgatory$ExpiredOperationReaper: [ExpirationReaper-0-topic]: Starting
>>> 20/10/20 12:11:50 INFO utils.ZKCheckedEphemeral: Creating /controller (is it secure? false)
>>> 20/10/20 12:11:50 INFO server.DelayedOperationPurgatory$ExpiredOperationReaper: [ExpirationReaper-0-Heartbeat]: Starting
>>> 20/10/20 12:11:50 INFO server.DelayedOperationPurgatory$ExpiredOperationReaper: [ExpirationReaper-0-Rebalance]: Starting
>>> 20/10/20 12:11:50 INFO utils.ZKCheckedEphemeral: Result of znode creation is: OK
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: 0 successfully elected as the controller
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Broker 0 starting become controller state transition
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:setData cxid:0x28 zxid:0x16 txntype:-1 reqpath:n/a Error Path:/controller_epoch Error:KeeperErrorCode = NoNode for /controller_epoch
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Controller 0 incremented epoch to 1
>>> 20/10/20 12:11:50 INFO group.GroupCoordinator: [GroupCoordinator 0]: Starting up.
>>> 20/10/20 12:11:50 INFO group.GroupCoordinator: [GroupCoordinator 0]: Startup complete.
>>> 20/10/20 12:11:50 INFO group.GroupMetadataManager: [Group Metadata Manager on Broker 0]: Removed 0 expired offsets in 0 milliseconds.
>>> 20/10/20 12:11:50 INFO transaction.ProducerIdManager: [ProducerId Manager 0]: Acquired new producerId block (brokerId:0,blockStartProducerId:0,blockEndProducerId:999) by writing to Zk with path version 1
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Partitions being reassigned: Map()
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Partitions already reassigned: Set()
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Resuming reassignment of partitions: Map()
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Currently active brokers in the cluster: Set()
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Currently shutting brokers in the cluster: Set()
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Current list of topics in the cluster: Set()
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: List of topics to be deleted: 
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: List of topics ineligible for deletion: 
>>> 20/10/20 12:11:50 INFO transaction.TransactionCoordinator: [Transaction Coordinator 0]: Starting up.
>>> 20/10/20 12:11:50 INFO transaction.TransactionMarkerChannelManager: [Transaction Marker Channel Manager 0]: Starting
>>> 20/10/20 12:11:50 INFO transaction.TransactionCoordinator: [Transaction Coordinator 0]: Startup complete.
>>> 20/10/20 12:11:50 INFO controller.ReplicaStateMachine: [Replica state machine on controller 0]: Started replica state machine with initial state -> Map()
>>> 20/10/20 12:11:50 INFO controller.PartitionStateMachine: [Partition state machine on Controller 0]: Started partition state machine with initial state -> Map()
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Broker 0 is ready to serve as the new controller with epoch 1
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Partitions undergoing preferred replica election: 
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Partitions that completed preferred replica election: 
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Skipping preferred replica election for partitions due to topic deletion: 
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Resuming preferred replica election for partitions: 
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Starting preferred replica leader election for partitions 
>>> 20/10/20 12:11:50 INFO controller.PartitionStateMachine: [Partition state machine on Controller 0]: Invoking state change to OnlinePartition for partitions 
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:delete cxid:0x3c zxid:0x19 txntype:-1 reqpath:n/a Error Path:/admin/preferred_replica_election Error:KeeperErrorCode = NoNode for /admin/preferred_replica_election
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: starting the controller scheduler
>>> 20/10/20 12:11:50 INFO utils.Mx4jLoader$: Will not load MX4J, mx4j-tools.jar is not in the classpath
>>> 20/10/20 12:11:50 INFO utils.ZKCheckedEphemeral: Creating /brokers/ids/0 (is it secure? false)
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:create cxid:0x46 zxid:0x1a txntype:-1 reqpath:n/a Error Path:/brokers Error:KeeperErrorCode = NodeExists for /brokers
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:create cxid:0x47 zxid:0x1b txntype:-1 reqpath:n/a Error Path:/brokers/ids Error:KeeperErrorCode = NodeExists for /brokers/ids
>>> 20/10/20 12:11:50 INFO utils.ZKCheckedEphemeral: Result of znode creation is: OK
>>> 20/10/20 12:11:50 INFO utils.ZkUtils: Registered broker 0 at path /brokers/ids/0 with addresses: EndPoint(127.0.0.1,64272,ListenerName(PLAINTEXT),PLAINTEXT)
>>> 20/10/20 12:11:50 WARN server.BrokerMetadataCheckpoint: No meta.properties file under dir /private/var/folders/jd/35_sh46s7zq0qc6khfw8hc800000gn/T/spark-a450b5f8-3645-4cbe-8b66-042d37b080a6/meta.properties
>>> 20/10/20 12:11:50 INFO utils.AppInfoParser: Kafka version : 0.11.0.0
>>> 20/10/20 12:11:50 INFO utils.AppInfoParser: Kafka commitId : cb8625948210849f
>>> 20/10/20 12:11:50 INFO server.KafkaServer: [Kafka Server 0], started
>>> 20/10/20 12:11:50 INFO broker.Main$: New topic: bfe7504c-d034-41fa-a0d0-e32e153be8a6
>>> 20/10/20 12:11:50 INFO broker.Main$: Creating producer properties...
>>> 20/10/20 12:11:50 INFO broker.Main$: OK
>>> 20/10/20 12:11:50 INFO broker.Main$: Creating kafka producer...
>>> 20/10/20 12:11:50 INFO producer.ProducerConfig: ProducerConfig values: 
	acks = 1
	batch.size = 16384
	bootstrap.servers = [127.0.0.1:64272]
	buffer.memory = 33554432
	client.id = 
	compression.type = none
	connections.max.idle.ms = 540000
	enable.idempotence = false
	interceptor.classes = null
	key.serializer = class org.apache.kafka.common.serialization.StringSerializer
	linger.ms = 0
	max.block.ms = 60000
	max.in.flight.requests.per.connection = 5
	max.request.size = 1048576
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partitioner.class = class org.apache.kafka.clients.producer.internals.DefaultPartitioner
	receive.buffer.bytes = 32768
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 0
	retry.backoff.ms = 100
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = null
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.timeout.ms = 60000
	transactional.id = null
	value.serializer = class org.apache.kafka.common.serialization.StringSerializer

>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: Newly added brokers: 0, deleted brokers: , all live brokers: 0
>>> 20/10/20 12:11:50 INFO controller.RequestSendThread: [Controller-0-to-broker-0-send-thread]: Starting
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: New broker startup callback for 0
>>> 20/10/20 12:11:50 INFO controller.RequestSendThread: [Controller-0-to-broker-0-send-thread]: Controller 0 connected to 127.0.0.1:64272 (id: 0 rack: null) for sending state change requests
>>> 20/10/20 12:11:50 INFO utils.AppInfoParser: Kafka version : 0.11.0.0
>>> 20/10/20 12:11:50 INFO utils.AppInfoParser: Kafka commitId : cb8625948210849f
>>> 20/10/20 12:11:50 INFO broker.Main$: OK
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:setData cxid:0x50 zxid:0x1d txntype:-1 reqpath:n/a Error Path:/config/topics/bfe7504c-d034-41fa-a0d0-e32e153be8a6 Error:KeeperErrorCode = NoNode for /config/topics/bfe7504c-d034-41fa-a0d0-e32e153be8a6
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:create cxid:0x51 zxid:0x1e txntype:-1 reqpath:n/a Error Path:/config/topics Error:KeeperErrorCode = NodeExists for /config/topics
>>> 20/10/20 12:11:50 INFO admin.AdminUtils$: Topic creation {"version":1,"partitions":{"0":[0]}}
>>> 20/10/20 12:11:50 INFO server.KafkaApis: [KafkaApi-0] Auto creation of topic bfe7504c-d034-41fa-a0d0-e32e153be8a6 with 1 partitions and replication factor 1 is successful
>>> 20/10/20 12:11:50 WARN clients.NetworkClient: Error while fetching metadata with correlation id 1 : {bfe7504c-d034-41fa-a0d0-e32e153be8a6=LEADER_NOT_AVAILABLE}
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: New topics: [Set(bfe7504c-d034-41fa-a0d0-e32e153be8a6)], deleted topics: [Set()], new partition replica assignment [Map([bfe7504c-d034-41fa-a0d0-e32e153be8a6,0] -> List(0))]
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: New topic creation callback for [bfe7504c-d034-41fa-a0d0-e32e153be8a6,0]
>>> 20/10/20 12:11:50 INFO controller.KafkaController: [Controller 0]: New partition creation callback for [bfe7504c-d034-41fa-a0d0-e32e153be8a6,0]
>>> 20/10/20 12:11:50 INFO controller.PartitionStateMachine: [Partition state machine on Controller 0]: Invoking state change to NewPartition for partitions [bfe7504c-d034-41fa-a0d0-e32e153be8a6,0]
>>> 20/10/20 12:11:50 INFO controller.ReplicaStateMachine: [Replica state machine on controller 0]: Invoking state change to NewReplica for replicas [Topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6,Partition=0,Replica=0]
>>> 20/10/20 12:11:50 INFO controller.PartitionStateMachine: [Partition state machine on Controller 0]: Invoking state change to OnlinePartition for partitions [bfe7504c-d034-41fa-a0d0-e32e153be8a6,0]
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:create cxid:0x59 zxid:0x21 txntype:-1 reqpath:n/a Error Path:/brokers/topics/bfe7504c-d034-41fa-a0d0-e32e153be8a6/partitions/0 Error:KeeperErrorCode = NoNode for /brokers/topics/bfe7504c-d034-41fa-a0d0-e32e153be8a6/partitions/0
>>> 20/10/20 12:11:50 INFO server.PrepRequestProcessor: Got user-level KeeperException when processing sessionid:0x175457e5b230000 type:create cxid:0x5a zxid:0x22 txntype:-1 reqpath:n/a Error Path:/brokers/topics/bfe7504c-d034-41fa-a0d0-e32e153be8a6/partitions Error:KeeperErrorCode = NoNode for /brokers/topics/bfe7504c-d034-41fa-a0d0-e32e153be8a6/partitions
>>> 20/10/20 12:11:50 INFO controller.ReplicaStateMachine: [Replica state machine on controller 0]: Invoking state change to OnlineReplica for replicas [Topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6,Partition=0,Replica=0]
>>> 20/10/20 12:11:50 INFO server.ReplicaFetcherManager: [ReplicaFetcherManager on broker 0] Removed fetcher for partitions bfe7504c-d034-41fa-a0d0-e32e153be8a6-0
>>> 20/10/20 12:11:50 INFO log.Log: Loading producer state from offset 0 for partition bfe7504c-d034-41fa-a0d0-e32e153be8a6-0 with message format version 2
>>> 20/10/20 12:11:50 INFO log.Log: Completed load of log bfe7504c-d034-41fa-a0d0-e32e153be8a6-0 with 1 log segments, log start offset 0 and log end offset 0 in 18 ms
>>> 20/10/20 12:11:50 INFO log.LogManager: Created log for partition [bfe7504c-d034-41fa-a0d0-e32e153be8a6,0] in /private/var/folders/jd/35_sh46s7zq0qc6khfw8hc800000gn/T/spark-a450b5f8-3645-4cbe-8b66-042d37b080a6 with properties {compression.type -> producer, message.format.version -> 0.11.0-IV2, file.delete.delay.ms -> 60000, max.message.bytes -> 1000012, min.compaction.lag.ms -> 0, message.timestamp.type -> CreateTime, min.insync.replicas -> 1, segment.jitter.ms -> 0, preallocate -> false, min.cleanable.dirty.ratio -> 0.5, index.interval.bytes -> 4096, unclean.leader.election.enable -> false, retention.bytes -> -1, delete.retention.ms -> 86400000, cleanup.policy -> [delete], flush.ms -> 9223372036854775807, segment.ms -> 604800000, segment.bytes -> 1073741824, retention.ms -> 604800000, message.timestamp.difference.max.ms -> 9223372036854775807, segment.index.bytes -> 10485760, flush.messages -> 1}.
>>> 20/10/20 12:11:50 INFO cluster.Partition: Partition [bfe7504c-d034-41fa-a0d0-e32e153be8a6,0] on broker 0: No checkpointed highwatermark is found for partition bfe7504c-d034-41fa-a0d0-e32e153be8a6-0
>>> 20/10/20 12:11:50 INFO cluster.Partition: Partition [bfe7504c-d034-41fa-a0d0-e32e153be8a6,0] on broker 0: bfe7504c-d034-41fa-a0d0-e32e153be8a6-0 starts at Leader Epoch 0 from offset 0. Previous Leader Epoch was: -1
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-0, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-1, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-2, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-3, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-4, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-5, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-6, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-7, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-8, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-9, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-10, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-11, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-12, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-13, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-14, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-15, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-16, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-17, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-18, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Producer Record: ProducerRecord(topic=bfe7504c-d034-41fa-a0d0-e32e153be8a6, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=null, value=streamtest-19, timestamp=null)
>>> 20/10/20 12:11:50 INFO broker.Main$: Closing kafka producer...
>>> 20/10/20 12:11:50 INFO producer.KafkaProducer: Closing the Kafka producer with timeoutMillis = 9223372036854775807 ms.
>>> 20/10/20 12:11:50 INFO epoch.LeaderEpochFileCache: Updated PartitionLeaderEpoch. New: {epoch:0, offset:0}, Current: {epoch:-1, offset-1} for Partition: bfe7504c-d034-41fa-a0d0-e32e153be8a6-0. Cache now contains 0 entries.
>>> 20/10/20 12:11:50 INFO broker.Main$: OK
>>> 20/10/20 12:11:50 INFO broker.Main$: Kafka broker is up at address: 127.0.0.1:64272 and data sent to topic:bfe7504c-d034-41fa-a0d0-e32e153be8a6
```

## kafka-client
```
>>> 20/10/20 12:13:15 INFO client.Main$: Creating AdminClient config properties...
>>> 20/10/20 12:13:15 INFO client.Main$: OK
>>> 20/10/20 12:13:15 INFO client.Main$: Creating AdminClient...
>>> 20/10/20 12:13:15 INFO admin.AdminClientConfig: AdminClientConfig values: 
	bootstrap.servers = [127.0.0.1:64272]
	client.dns.lookup = use_all_dns_ips
	client.id = 
	connections.max.idle.ms = 300000
	default.api.timeout.ms = 60000
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 2147483647
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	security.providers = null
	send.buffer.bytes = 131072
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2]
	ssl.endpoint.identification.algorithm = https
	ssl.engine.factory.class = null
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLSv1.2
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS

>>> 20/10/20 12:13:15 INFO utils.AppInfoParser: Kafka version: 2.6.0
>>> 20/10/20 12:13:15 INFO utils.AppInfoParser: Kafka commitId: 62abe01bee039651
>>> 20/10/20 12:13:15 INFO utils.AppInfoParser: Kafka startTimeMs: 1603188795254
>>> 20/10/20 12:13:15 INFO client.Main$: OK
>>> 20/10/20 12:13:15 INFO client.Main$: Calling listTopics...
>>> 20/10/20 12:13:15 INFO client.Main$: topics: [bfe7504c-d034-41fa-a0d0-e32e153be8a6]
>>> 20/10/20 12:13:15 INFO client.Main$: Calling describeTopics...
>>> 20/10/20 12:13:15 INFO client.Main$: topicsDescription: {bfe7504c-d034-41fa-a0d0-e32e153be8a6=(name=bfe7504c-d034-41fa-a0d0-e32e153be8a6, internal=false, partitions=(partition=0, leader=127.0.0.1:64272 (id: 0 rack: null), replicas=127.0.0.1:64272 (id: 0 rack: null), isr=127.0.0.1:64272 (id: 0 rack: null)), authorizedOperations=null)}
>>> 20/10/20 12:13:15 INFO client.Main$: Calling listOffsets...
>>> 20/10/20 12:13:15 INFO client.Main$: listOffsetsResult: {bfe7504c-d034-41fa-a0d0-e32e153be8a6-0=ListOffsetsResultInfo(offset=20, timestamp=-1, leaderEpoch=Optional.empty)}
>>> 20/10/20 12:13:15 INFO client.Main$: Closing kafka admin...
>>> 20/10/20 12:13:15 INFO client.Main$: OK
```
