package controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import entities.Planning;
import services.PlanningServices;
 
@ManagedBean
@SessionScoped
public class PlanningController implements Serializable {
 
	@EJB
	private PlanningServices planningServ;
	
	
    private ScheduleModel eventModel;
     
 
    private ScheduleEvent event = new DefaultScheduleEvent();
 
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        fillPlanning();
         
       
    }
     
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
    }
     
    public ScheduleModel getEventModel() {
        return eventModel;
    }
      
            
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
    	System.out.println("ba oui");
        this.event = event;
    }
     
    public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null)
            eventModel.addEvent(event);
        else
            eventModel.updateEvent(event);
         
        Planning evenement = new Planning();
        evenement.setTitre(event.getTitle());
        evenement.setStartime(event.getStartDate());
        evenement.setEndtime(event.getEndDate());
		System.out.println("Ajout " + event.getId());
		evenement.setIdPla(event.getId());
        evenement.setIdClasse(1);
        
        planningServ.mergePlanning(evenement);
        
        event = new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
    	
    	ScheduleEvent modifiedEvent = event.getScheduleEvent();
    	
    	 Planning evenement = new Planning();
         evenement.setTitre(modifiedEvent.getTitle());
         evenement.setStartime(modifiedEvent.getStartDate());
         evenement.setEndtime(modifiedEvent.getEndDate());
         evenement.setIdClasse(1);
        // evenement.setIdPla(Integer.parseInt(modifiedEvent.getId()));
         
         //planningServ.mergePlanning(evenement);
    	
    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta()+",Event : " + modifiedEvent.getTitle());
    	
    	
        addMessage(message);
        
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    private void fillPlanning(){
    	List<Planning> planning = planningServ.getListPlanning(1);
    	
    	for(Planning event : planning){
    		ScheduleEvent evenement = new DefaultScheduleEvent(event.getTitre(), event.getStartime(), event.getEndtime());
    		evenement.setId(event.getIdPla());
    		eventModel.addEvent(evenement);
    	}
    }
}