package org.jbpm.runtime.manager.impl.tx;

import org.drools.persistence.TransactionSynchronization;
import org.kie.internal.runtime.manager.Runtime;
import org.kie.internal.runtime.manager.RuntimeManager;

public class DisposeSessionTransactionSynchronization implements TransactionSynchronization {

	private Runtime runtime;
	private RuntimeManager manager;
	
	public DisposeSessionTransactionSynchronization(RuntimeManager manager, Runtime runtime) {
		this.manager = manager;
	    this.runtime = runtime;
	}
	
	public void beforeCompletion() {
	}

	public void afterCompletion(int status) {
	    try {
	        manager.disposeRuntime(runtime);
	    } catch (Throwable e) {
	        // catch exception as it's only clean up and should not affect runtime
	    }
	}

}
