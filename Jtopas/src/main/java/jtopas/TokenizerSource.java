/*
 * TokenizerSource.java: Data source for the PluginTokenizer.
 *
 * Copyright (C) 2001 Heiko Blau
 *
 * This file belongs to the JTopas Library.
 * JTopas is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by the 
 * Free Software Foundation; either version 2.1 of the License, or (at your 
 * option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
 * FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along
 * with JTopas. If not, write to the
 *
 *   Free Software Foundation, Inc.
 *   59 Temple Place, Suite 330, 
 *   Boston, MA 02111-1307 
 *   USA
 *
 * or check the Internet: http://www.fsf.org
 *
 * Contact:
 *   email: heiko@susebox.de 
 */

package jtopas;


//-----------------------------------------------------------------------------
// Interface TokenizerSource
//

/**<p>
 * This class is an extension to {@link util.AbstractTokenizer}.
 * It can be used instead of ({@link util.InputStreamTokenizer}
 * when that class is not approbriate for the situation of the user (for instance,
 * if its performance is to low).
 *</p>
 *
 * @see     util.Tokenizer
 * @see     util.AbstractTokenizer
 * @author  Heiko Blau
 */
public interface TokenizerSource extends Plugin {
  
  /**
   * A basic method to supply data to a {@link util.Tokenizer}.
   *
   * @param cbuf      buffer to receive data
   * @param offset    position from where the data should be inserted in <CODE>cbuf</CODE>
   * @param maxChars  maximum number of characters to be read into <CODE>cbuf</CODE>
   * @return actually read characters or -1 on an end-of-file condition
   * @throws Exception anything that could happen during read, most likely {@link java.io.IOException}
   */
  int read(char[] cbuf, int offset, int maxChars) throws Exception;
}
