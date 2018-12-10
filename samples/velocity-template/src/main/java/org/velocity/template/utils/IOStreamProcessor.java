package org.velocity.template.utils;

import java.io.IOException;
import java.io.InputStream;

public interface IOStreamProcessor {
	<T> T process(InputStream input) throws IOException;
}
