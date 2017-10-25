package com.emc.mongoose.storage.driver.nfs;

import com.emc.ecs.nfsclient.nfs.nfs3.Nfs3;

import com.emc.mongoose.api.common.exception.OmgShootMyFootException;
import com.emc.mongoose.api.model.data.DataInput;
import com.emc.mongoose.api.model.io.IoType;
import com.emc.mongoose.api.model.io.task.data.DataIoTask;
import com.emc.mongoose.api.model.item.DataItem;
import com.emc.mongoose.api.model.item.ItemFactory;
import com.emc.mongoose.api.model.storage.Credential;
import com.emc.mongoose.storage.driver.nio.base.NioStorageDriverBase;
import com.emc.mongoose.ui.config.load.LoadConfig;
import com.emc.mongoose.ui.config.storage.StorageConfig;
import com.emc.mongoose.ui.config.storage.net.node.NodeConfig;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class NfsStorageDriver<I extends DataItem, O extends DataIoTask<I>>
extends NioStorageDriverBase<I, O> {

	//private final ConcurrentMap<String, Nfs3> nfsClient;
	private final String storageNodeAddr;
	private final int connAttemptsLimit;

	public NfsStorageDriver(
		final String testStepName, final DataInput dataInput, final LoadConfig loadConfig,
		final StorageConfig storageConfig, final boolean verifyFlag
	) throws OmgShootMyFootException {

		super(testStepName, dataInput, loadConfig, storageConfig, verifyFlag);

		final NodeConfig nodeConfig = storageConfig.getNetConfig().getNodeConfig();
		connAttemptsLimit = nodeConfig.getConnAttemptsLimit();
		final List<String> allNodes = nodeConfig.getAddrs();
		if(allNodes == null || allNodes.isEmpty()) {
			throw new OmgShootMyFootException("No endpoint address is specified");
		}
		storageNodeAddr = allNodes.get(0);
		//nfsClient = new Nfs3(storageNodeAddr, )
	}

	@Override
	protected void invokeNio(final O ioTask) {

	}

	@Override
	protected String requestNewPath(final String path) {
		return null;
	}

	@Override
	protected String requestNewAuthToken(final Credential credential) {
		return null;
	}

	@Override
	public List<I> list(
		final ItemFactory<I> itemFactory, final String path, final String prefix, final int idRadix,
		final I lastPrevItem, final int count
	)
	throws IOException {
		return null;
	}

	@Override
	public void adjustIoBuffers(final long avgDataItemSize, final IoType ioType)
	throws RemoteException {

	}
}
