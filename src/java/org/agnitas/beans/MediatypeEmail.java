/*********************************************************************************
 * The contents of this file are subject to the OpenEMM Public License Version 1.1
 * ("License"); You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.agnitas.org/openemm.
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied.  See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is OpenEMM.
 * The Initial Developer of the Original Code is AGNITAS AG. Portions created by
 * AGNITAS AG are Copyright (C) 2006 AGNITAS AG. All Rights Reserved.
 *
 * All copies of the Covered Code must include on each user interface screen,
 * visible to all users at all times
 *    (a) the OpenEMM logo in the upper left corner and
 *    (b) the OpenEMM copyright notice at the very bottom center
 * See full license, exhibit B for requirements.
 ********************************************************************************/

package org.agnitas.beans;

/**
 *
 * @author mhe
 */
public interface MediatypeEmail {
    String ONEPIXEL_BOTTOM = "bottom";


    String ONEPIXEL_NONE = "none";

    String ONEPIXEL_TOP = "top";

    /**
     * Getter for property charset.
     * 
     * @return Value of property charset.
     */
    String getCharset();

    /**
     * Getter for property fromAdr.
     * 
     * @return Value of property fromAdr.
     */
    String getFromAdr();

    /**
     * Getter for property linefeed.
     * 
     * @return Value of property linefeed.
     */
    int getLinefeed();

    /**
     * Getter for property mailFormat.
     * 
     * @return Value of property mailFormat.
     */
    int getMailFormat();

    /**
     * Getter for property onepixel.
     * 
     * @return Value of property onepixel.
     */
    String getOnepixel();

    /**
     * Getter for property replyAdr.
     * 
     * @return Value of property replyAdr.
     */
    String getReplyAdr();

    /**
     * Getter for property subject.
     * 
     * @return Value of property subject.
     */
    String getSubject();

    /**
     * Getter for parameters.
     *
     * @return Resultset
     */
    String paramValue();

    boolean parseParam() throws Exception;

    /**
     * Setter for property charset.
     * 
     * @param charset New value of property charset.
     */
    void setCharset(String charset);

    /**
     * Setter for property fromAdr.
     * 
     * @param fromAdr New value of property fromAdr.
     */
    void setFromAdr(String fromAdr);

    /**
     * Setter for property linefeed.
     * 
     * @param linefeed New value of property linefeed.
     */
    void setLinefeed(int linefeed);

    /**
     * Setter for property mailFormat.
     * 
     * @param mailFormat New value of property mailFormat.
     */
    void setMailFormat(int mailFormat);

    /**
     * Setter for property onepixel.
     * 
     * @param onepixel New value of property onepixel.
     */
    void setOnepixel(String onepixel);

    /**
     * Setter for property replyAdr.
     * 
     * @param replyAdr New value of property replyAdr.
     */
    void setReplyAdr(String replyAdr);

    /**
     * Setter for property subject.
     * 
     * @param subject New value of property subject.
     */
    void setSubject(String subject);

    /**
     * Getter for property param.
     *
     * @return Value of property param.
     */
    public Mediatype getParam();

    /**
     * Setter for property param.
     *
     * @param param New value of property param.
     * @throws java.lang.Exception 
     */
    public void setParam(Mediatype param) throws Exception;
    
    /**
     * Getter for property mailingID.
     *
     * @return Value of property mailingID.
     */
    public int getMailingID();
    
     /**
     * Setter for property mailingID.
     * 
     * @param mailingID New value of property mailingID.
     */
    public void setMailingID(int mailingID);
    
}