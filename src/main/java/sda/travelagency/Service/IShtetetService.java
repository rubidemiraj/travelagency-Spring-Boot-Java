package sda.travelagency.Service;

import sda.travelagency.model.Shtet;

import java.util.List;

public interface IShtetetService {

    List<Shtet> getAllShtetet();
    void saveShtet(Shtet shtet);
    Shtet getShtetById(long id);
    void deleteShtetById(long id);

}
