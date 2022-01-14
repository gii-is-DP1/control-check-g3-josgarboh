package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    List<RecoveryRoom> findAll();
    
    @Query("SELECT t FROM RecoveryRoomType t")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT t FROM RecoveryRoomType t WHERE t.name =:name")
    RecoveryRoomType getRecoveryRoomType(@Param("name") String name);
    
    
    @Query("SELECT rooms FROM RecoveryRoom rooms WHERE rooms.size >:size")
    List<RecoveryRoom> findBySizeMoreThan(@Param("size") Double size);
}
