package com.prototype.product.service.implement;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LockImplements {

	private static final Set<String> lockedKeys = new HashSet<>();

	void lock(String key) {
		synchronized (lockedKeys) {
			while (!lockedKeys.add(key)) {
				try {
					lockedKeys.wait();
				} catch (InterruptedException e) {
					log.error("...");
					throw new RuntimeException(e);
				}
			}
		}
	}

	void unlock(String key) {
		synchronized (lockedKeys) {
			lockedKeys.remove(key);
			lockedKeys.notifyAll();
		}
	}
}
