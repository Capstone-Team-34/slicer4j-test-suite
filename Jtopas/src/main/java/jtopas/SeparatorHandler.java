/*
 * SeparatorHandler.java: Pluggin for the PluginTokenizer.
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
// Interface SeparatorHandler
//

/**<p>
 * This interface must be implemented by classes that should be used as a 
 * separator handler plugin in the {@link PluginTokenizer}.
 *</p><p>
 * This interface is deprecated. Use the new {@link jtopas.spi.SeparatorHandler}
 * interface instead.
 *</p>
 *
 * @see     util.Tokenizer
 * @see     util.AbstractTokenizer
 * @author  Heiko Blau
 * @deprecated  replaced by the new {@link jtopas.spi.SeparatorHandler} interface
 */
public interface SeparatorHandler extends Plugin {
  
  /**
   * This method checks if the character is a separator.
   *
   * @param testChar  check this character
   * @return <CODE>true</CODE> if the given character is a separator,
   *         <CODE>false</CODE> otherwise
   */
  public boolean isSeparator(char testChar);
}
