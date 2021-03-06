/*
The contents of this file are subject to the Common Public Attribution License
Version 1.0 (the "License"); you may not use this file except in compliance with
the License. You may obtain a copy of the License at
http://www.projity.com/license . The License is based on the Mozilla Public
License Version 1.1 but Sections 14 and 15 have been added to cover use of
software over a computer network and provide for limited attribution for the
Original Developer. In addition, Exhibit A has been modified to be consistent
with Exhibit B.

Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
specific language governing rights and limitations under the License. The
Original Code is OpenProj. The Original Developer is the Initial Developer and
is Projity, Inc. All portions of the code written by Projity are Copyright (c)
2006, 2007. All Rights Reserved. Contributors Projity, Inc.

Alternatively, the contents of this file may be used under the terms of the
Projity End-User License Agreeement (the Projity License), in which case the
provisions of the Projity License are applicable instead of those above. If you
wish to allow use of your version of this file only under the terms of the
Projity License and not to allow others to use your version of this file under
the CPAL, indicate your decision by deleting the provisions above and replace
them with the notice and other provisions required by the Projity  License. If
you do not delete the provisions above, a recipient may use your version of this
file under either the CPAL or the Projity License.

[NOTE: The text of this license may differ slightly from the text of the notices
in Exhibits A and B of the license at http://www.projity.com/license. You should
use the latest text at http://www.projity.com/license for your modifications.
You may not remove this license text from the source files.]

Attribution Information: Attribution Copyright Notice: Copyright � 2006, 2007
Projity, Inc. Attribution Phrase (not exceeding 10 words): Powered by OpenProj,
an open source solution from Projity. Attribution URL: http://www.projity.com
Graphic Image as provided in the Covered Code as file:  openproj_logo.png with
alternatives listed on http://www.projity.com/logo

Display of Attribution Information is required in Larger Works which are defined
in the CPAL as a work which combines Covered Code or portions thereof with code
not governed by the terms of the CPAL. However, in addition to the other notice
obligations, all copies of the Covered Code in Executable and Source Code form
distributed must, as a form of attribution of the original author, include on
each user interface screen the "OpenProj" logo visible to all users.  The
OpenProj logo should be located horizontally aligned with the menu bar and left
justified on the top left of the screen adjacent to the File menu.  The logo
must be at least 100 x 25 pixels.  When users click on the "OpenProj" logo it
must direct them back to http://www.projity.com.
*/
package com.projity.undo;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.projity.field.Field;
import com.projity.field.FieldContext;
import com.projity.field.FieldParseException;
import com.projity.field.FieldSetOptions;
import com.projity.grouping.core.Node;
import com.projity.grouping.core.model.NodeModel;

/**
 *
 */
public class ModelFieldEdit extends AbstractUndoableEdit{
	protected NodeModel model;
	protected Field field;
	protected Node node;
	protected Object value,oldValue;
	protected FieldContext context;
	protected Object source;
	protected FieldSetOptions options;

	/**
	 * @param model
	 * @param field
	 * @param node
	 * @param value
	 * @param oldValue
	 * @param context
	 */
	public ModelFieldEdit(NodeModel model, Field field,
			Node node, Object source,Object value, Object oldValue,
			FieldContext context,FieldSetOptions options) {
		super();
		this.model = model;
		this.field = field;
		this.node = node;
		this.value = value;
		this.oldValue = oldValue;
		this.context = context;
		this.source=source;
		this.options=options;
	}
	public boolean canRedo() {
		return super.canRedo();
	}
	public boolean canUndo() {
		return super.canUndo();
	}
	public String getPresentationName() {
		return "ModelField(id=" + field.getId() + ", node=" + node + ", value=" + value + ", oldValue=" + oldValue + ")";


	}
	public void redo() throws CannotRedoException {
		super.redo();
		try {
			model.setFieldValue(field,node,source,value,context,options,NodeModel.EVENT);
		} catch (FieldParseException e) {
			e.printStackTrace();
		}
	}
	public void undo() throws CannotUndoException {
		super.undo();
		try {
			model.setFieldValue(field,node,source,oldValue,context,options,NodeModel.EVENT);
		} catch (FieldParseException e) {
			e.printStackTrace();
		}
	}
//	public FieldContext getContext() {
//		return context;
//	}
//	public void setContext(FieldContext context) {
//		this.context = context;
//	}
//	public Field getField() {
//		return field;
//	}
//	public void setField(Field field) {
//		this.field = field;
//	}
//	public NodeModel getModel() {
//		return model;
//	}
//	public void setModel(NodeModel model) {
//		this.model = model;
//	}
//	public Node getNode() {
//		return node;
//	}
//	public void setNode(Node node) {
//		this.node = node;
//	}
//	public Object getOldValue() {
//		return oldValue;
//	}
//	public void setOldValue(Object oldValue) {
//		this.oldValue = oldValue;
//	}
//	public Object getSource() {
//		return source;
//	}
//	public void setSource(Object source) {
//		this.source = source;
//	}
//	public Object getValue() {
//		return value;
//	}
//	public void setValue(Object value) {
//		this.value = value;
//	}
//	public FieldSetOptions getOptions() {
//		return options;
//	}
//	public void setOptions(FieldSetOptions options) {
//		this.options = options;
//	}


}
