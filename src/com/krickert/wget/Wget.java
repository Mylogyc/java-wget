package com.krickert.wget;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.BitSet;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An implementation of the
 */
public class Wget {

	private static final Map<Integer, ReadableByteChannelWrapper> ACTIVE_DOWNLOADS;
	private static final BitSet CONCURRENT_DOWNLOAD_IDS;

	static {
		ACTIVE_DOWNLOADS = Collections.synchronizedMap(new LinkedHashMap<>());
		CONCURRENT_DOWNLOAD_IDS = new BitSet(255);
	}

	public static byte get(String localFile, String remoteLocation) {
		try (ReadableByteChannelWrapper remote = new ReadableByteChannelWrapper(
				Channels.newChannel(new BufferedInputStream(new URL(remoteLocation).openStream())));
				BufferedOutputStream bufferedOut = new BufferedOutputStream(new FileOutputStream(localFile), 1024)) {

			int id = CONCURRENT_DOWNLOAD_IDS.nextClearBit(0);

			byte data[] = new byte[1024];
			boolean fileComplete = false;
			int count = 0;
			while (!fileComplete) {
				count = bufferedOut.

				if (count <= 0) {
					fileComplete = true;
				} else {
					bufferedOut.write(data, 0, count);
				}
			}
		} catch (IOException e) {
			return -1;
		}

	}

}
