package co.edu.unal.software_engineering.labs.repository;

import co.edu.unal.software_engineering.labs.model.Association;
import co.edu.unal.software_engineering.labs.model.Role;
import co.edu.unal.software_engineering.labs.model.User;
<<<<<<< HEAD

import java.util.List;

=======
>>>>>>> upstream/master
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Integer>{

<<<<<<< HEAD
  @Query( "SELECT a FROM Association a JOIN a.userRole ur" +
          " WHERE ur.userRolePK.user = :user AND ur.userRolePK.role IN :roles")
  List<Association> findByUserAndRoles(User user, List<Role> roles);
  
=======
    @Query( "SELECT a FROM Association a JOIN a.userRole ur" +
            "   WHERE ur.userRolePK.user = :user AND ur.userRolePK.role IN :roles" )
    List<Association> getAssociationsByUserAndRoles( User user, List<Role> roles );

>>>>>>> upstream/master
}
