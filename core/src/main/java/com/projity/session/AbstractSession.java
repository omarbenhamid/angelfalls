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
package com.projity.session;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.Closure;

import com.projity.company.ApplicationUser;
import com.projity.job.Job;
import com.projity.job.JobQueue;
import com.projity.job.JobRunnable;
import com.projity.pm.resource.Resource;
import com.projity.pm.task.Project;

public abstract class AbstractSession implements Session{
	protected JobQueue jobQueue=null;
	public JobQueue getJobQueue() {
		return jobQueue;
	}
	public void setJobQueue(JobQueue jobQueue) {
		this.jobQueue = jobQueue;
	}
	public void schedule(Job job){
    	jobQueue.schedule(job);
    }

    protected boolean initialized;
    public boolean isInitialized(){
    	return initialized;
    }
	public void init(Object o){
		initialized=true;
	}

	public ApplicationUser getUser() {
		return null;
	}
	public void setUser(ApplicationUser user){

	}
	public void logException(Exception e){}
	public void logString(String s){}

    //public Job getSaveProjectJob(final Project project, final boolean cloneMaster){
    public Job getSaveProjectJob(final Project project, SaveOptions opt){
    	List<Project> projects=new ArrayList();
    	projects.add(project);
    	return getSaveProjectJob(projects,opt);
    }

    public Job getEmptyJob(String name,final Object result){
    	Job job=new Job(jobQueue,name,"Job...",false);
    	job.addRunnable(new JobRunnable(name,0.0f){
    		public Object run() throws Exception{
    			return result;
    		}
    	});
    	return job;
    }
	public Closure getPostOpenAction(LoadOptions opt) {
		return null;
	}

    public boolean getLock(Project project, boolean force) {
    	return true;
    }
	public boolean publish(Project project, boolean pullActualsFirst) {
		return true;
	}
	public boolean revert(Project project) {
		return false;
	}
	public void refreshMetadata(Project project) {
		
	}
	public boolean needsReload(Project project) {
		return false;
	}
	public boolean pullActuals(Project project) {
		return false;
	}
	public boolean isSavable(final Project project) {
		return true;
	}
	public void removeAllocation(Project project, Resource resource) {
	}
	public void readCurrencyData(Project project) {
	}

}
