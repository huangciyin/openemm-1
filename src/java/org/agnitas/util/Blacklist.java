/*********************************************************************************
 * The contents of this file are subject to the Common Public Attribution
 * License Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.openemm.org/cpal1.html. The License is based on the Mozilla
 * Public License Version 1.1 but Sections 14 and 15 have been added to cover
 * use of software over a computer network and provide for limited attribution
 * for the Original Developer. In addition, Exhibit A has been modified to be
 * consistent with Exhibit B.
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * The Original Code is OpenEMM.
 * The Original Developer is the Initial Developer.
 * The Initial Developer of the Original Code is AGNITAS AG. All portions of
 * the code written by AGNITAS AG are Copyright (c) 2007 AGNITAS AG. All Rights
 * Reserved.
 * 
 * Contributor(s): AGNITAS AG. 
 ********************************************************************************/
package org.agnitas.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Vector;

/**
 * This is the collection of blacklisted emails and
 * email pattern
 */
public class Blacklist {
    /** contains all elements on the blacklist */
    private Vector  elem;
    /** used to detect and avoud double tnries */
    private HashSet seen;
    /** contains all non wildcard entries */
    private Hashtable   exact;
    /** contains a list of all wildcard records */
    private Vector  wildcards;
    /** number of entries from global blacklist */
    private int globalCount;
    /** number of entries from local blacklist */
    private int localCount;
    /** number of entries in wildcards */
    private int wcount;
    /** path to bouncelog file */
    private String  bouncelog;

    /** Constructor for the class
     */
    public Blacklist () {
        elem = new Vector ();
        seen = new HashSet ();
        exact = new Hashtable ();
        wildcards = new Vector ();
        localCount = 0;
        globalCount = 0;
        wcount = 0;

        String  separator = System.getProperty ("file.separator");
        String  home = System.getProperty ("user.home", ".");

        bouncelog = home + separator + "var" + separator + "spool" + separator + "log" + separator + "extbounce.log";
    }

    /** sets the path to the bouncelog file
     * @parm nBouncelog the path to the file
     */
    public void setBouncelog (String nBouncelog) {
        bouncelog = nBouncelog;
    }

    /** add a email or pattern to the blacklist
     * @param email the email or pattern
     * @param global true, if this entry is on the global blacklist
     */
    public void add (String email, boolean global) {
        email = email.toLowerCase ();
        if (! seen.contains (email)) {
            Blackdata   bd = new Blackdata (email, global);

            elem.add (bd);
            if (global) {
                ++globalCount;
            } else {
                ++localCount;
            }
            seen.add (email);
            if (bd.isWildcard ()) {
                wildcards.add (bd);
                ++wcount;
            } else {
                exact.put (email, bd);
            }
        }
    }

    /** Returns wether an email is on the blacklist or not
     * @param email the email to check
     * @return the entry, if the email is blacklisted, null otherwise
     */
    public Blackdata isBlackListed (String email) {
        Blackdata   rc = null;

        email = email.toLowerCase ();
        rc = (Blackdata) exact.get (email);
        for (int n = 0; (rc == null) && (n < wcount); ++n) {
            Blackdata   e = (Blackdata) wildcards.elementAt (n);

            if (e.matches (email)) {
                rc = e;
            }
        }
        return rc;
    }

    /** returns the number of entries on the global blacklist
     * @return count
     */
    public int globalCount () {
        return globalCount;
    }

    /** returns the number of entries on the local blacklist
     * @return count
     */
    public int localCount () {
        return localCount;
    }
    
    /** Write blacklisted entry to bounce log file
     * @param mailingID the mailingID
     * @param customerID the customerID to mark as blacklisted
     */
    public void writeBounce (long mailingID, long customerID) {
        if (bouncelog != null) {
            FileOutputStream    file = null;
            try {
                String  entry = "5.9.9;0;" + mailingID + ";0;" + customerID + ";admin=auto opt-out due to blacklist\tstatus=blacklist\n";

                file = new FileOutputStream (bouncelog, true);
                file.write (entry.getBytes ("ISO-8859-1"));
            } catch (FileNotFoundException e) {
                ;
            } catch (IOException e) {
                ;
            } finally {
                if (file != null) {
                    try {
                        file.close ();
                    } catch (IOException e) {
                        ;
                    }
                }
            }
        }
    }
}
