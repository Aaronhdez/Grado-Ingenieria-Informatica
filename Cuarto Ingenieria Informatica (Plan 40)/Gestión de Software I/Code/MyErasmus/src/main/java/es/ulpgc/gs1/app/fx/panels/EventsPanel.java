package es.ulpgc.gs1.app.fx.panels;

import es.ulpgc.gs1.app.fx.dialogs.ViewEventDialog;
import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.Usuario;
import es.ulpgc.gs1.persistence.ExternalPanel;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EventsPanel extends JPanel implements ExternalPanel {
    private final JList list;
    private final JScrollPane scrollpane;
    private Usuario usuario;
    
    public EventsPanel() {
        scrollpane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        this.init();
    }
    
    private void init() {
        
        scrollpane.setViewportView(list);
        list.addListSelectionListener(getSelectionListener(this));
        this.reloadEvents();

        javax.swing.GroupLayout eventsPanel2Layout = new javax.swing.GroupLayout(this);
        this.setLayout(eventsPanel2Layout);
        eventsPanel2Layout.setHorizontalGroup(
            eventsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        eventsPanel2Layout.setVerticalGroup(
            eventsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
        );
        this.add(scrollpane);
    }

    @Override
    public void setUserInstance(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public void update() {
        this.reloadEvents();
    }

    private void reloadEvents() {
        ArrayList<Object> eventsFromDatabase = SQLHelper.getAllUniversityAdvFromDatabase();
        DefaultListModel<String> eventsList = getModelFrom(eventsFromDatabase);
        this.list.setModel(eventsList);
    }
    
    private DefaultListModel<String> getModelFrom(ArrayList<Object> eventsFromDatabase) {
        DefaultListModel<String> rest = new DefaultListModel<>();
        for(int i = 0; i < eventsFromDatabase.size(); i++){
            rest.addElement(eventsFromDatabase.get(i).toString());
        }
        return rest;
    }
     
    
    private ListSelectionListener getSelectionListener(Component component) {
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if(list.getSelectedValue() != null){
                    String selectedValue = list.getSelectedValue().toString();
                    ArrayList<Object> dataToTransfer = SQLHelper.GetDataFromUniversityEvent(selectedValue);
                    System.out.println(dataToTransfer.get(0));
                    //new ViewEventDialog(component, dataToTransfer);
                }
            }
        };
    }
}
