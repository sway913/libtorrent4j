package org.libtorrent4j;

import org.junit.Test;
import org.libtorrent4j.swig.announce_endpoint;
import org.libtorrent4j.swig.announce_endpoint_vector;
import org.libtorrent4j.swig.announce_entry;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author aldenml
 */
public class AnnounceEntryTest {

    @Test
    public void testEndpoints() {
        AnnounceEntry e = new AnnounceEntry(createNative());

        List<AnnounceEndpoint> endpoints = e.endpoints();

        assertTrue(endpoints.get(0).enabled());
        assertFalse(endpoints.get(1).enabled());
    }

    private announce_entry createNative() {
        announce_entry e = new announce_entry();

        announce_endpoint_vector v = new announce_endpoint_vector();

        announce_endpoint endp1 = new announce_endpoint();
        endp1.setEnabled(true);
        v.add(endp1);

        announce_endpoint endp2 = new announce_endpoint();
        endp2.setEnabled(false);
        v.add(endp2);

        e.setEndpoints(v);

        return e;
    }
}
