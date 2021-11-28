/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositee1.view;

/**
 *
 * @author Usuario
 */
public interface File {
    default void add(File f) {};
    default void remove(File f){};
    default File getFile(int file){
        return null;
    };
    void operation();
    void setLevel(int level);
    void setIndent();
    String getCompletePath();
}
