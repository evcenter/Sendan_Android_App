/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ev.exam.arduinobt;

import java.util.zip.Checksum;

/**
 * Calculate CRC-8
 * <p>
 * <a href="http://en.wikipedia.org/wiki/Cyclic_redundancy_check">CRC-8</a>
 */
public class CRC8 implements Checksum {
	private static final int poly = 0x0107;
	private int crc = 0;

	@Override
	public void update(final byte[] input, final int offset, final int len) {
		for (int i = 0; i < len; i++) {
			update(input[offset + i]);
		}
	}

	public void update(final byte[] input) {
		update(input, 0, input.length);
	}

	private final void update(final byte b) {
		crc ^= b;
		for (int j = 0; j < 8; j++) {
			if ((crc & 0x80) != 0) {
				crc = ((crc << 1) ^ poly);
			} else {
				crc <<= 1;
			}
		}
		crc &= 0xFF;
	}

	@Override
	public void update(final int b) {
		update((byte) b);
	}

	@Override
	public long getValue() {
		return (crc & 0xFF);
	}

	@Override
	public void reset() {
		crc = 0;
	}


}