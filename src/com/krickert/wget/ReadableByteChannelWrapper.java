package com.krickert.wget;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/**
 * Wrapper for a ReadableByteChannel that stores the number of bytes read.
 * 
 * @author par (http://stackoverflow.com/a/11068356)
 */
public class ReadableByteChannelWrapper implements ReadableByteChannel {
	/** The wrapped ReadableByteChannel. */
	private final ReadableByteChannel rbc;

	/** The number of bytes read. */
	private long bytesRead;

	/**
	 * Constructor.
	 * 
	 * @param rbc
	 *            the ReadableByteChannel to wrap
	 */
	public ReadableByteChannelWrapper(ReadableByteChannel rbc) {
		this.rbc = rbc;
	}

	@Override
	public void close() throws IOException {
		rbc.close();
	}

	@Override
	public boolean isOpen() {
		return rbc.isOpen();
	}

	@Override
	public int read(ByteBuffer bb) throws IOException {
		int bytes;
		if ((bytes = rbc.read(bb)) > 0)
			bytesRead += bytes;
		return bytes;
	}

	/**
	 * Returns the number of bytes read so far.
	 */
	public long getReadSoFar() {
		return bytesRead;
	}
}
