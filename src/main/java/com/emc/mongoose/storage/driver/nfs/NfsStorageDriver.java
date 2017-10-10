package com.emc.mongoose.storage.driver.nfs;

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

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

public class NfsStorageDriver<I extends DataItem, O extends DataIoTask<I>>
extends NioStorageDriverBase<I, O> {

	public NfsStorageDriver(
		final String jobName, final DataInput contentSrc, final LoadConfig loadConfig,
		final StorageConfig storageConfig, final boolean verifyFlag
	) throws OmgShootMyFootException {
		super(jobName, contentSrc, loadConfig, storageConfig, verifyFlag);
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
