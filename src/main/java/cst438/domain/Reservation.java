package cst438.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Reservation")
public class Reservation {
   @Id
   @GeneratedValue
   @Column(name="id")
   private Long id;

   @NotEmpty
   @Size(min = 1)
   @Column(name="cityName", nullable=false)
   private String cityName;

   @NotEmpty
   @Email
   @Size(min = 1)
   @Column(name="email", nullable=false)
   private String email;

   @NotNull
   @Size(min = 1)
   @Column(name="level", nullable=false)
   private String level;

   
   
   public Reservation(Long id, @NotEmpty @Size(min = 1) String cityName,
         @NotEmpty @Email @Size(min = 1) String email,
         @NotNull @Size(min = 1) String level) {
      this.id = id;
      this.cityName = cityName;
      this.email = email;
      this.level = level;
   }

   public Long getId() {
      return id;
   }
   
   public void setId(Long id) {
      this.id = id;
   }

   public String getCityName() {
      return cityName;
   }
   
   public void setCityName(String cityName) {
      this.cityName = cityName;
   }
   
   public String getEmail() {
      return email;
   }
   
   public void setEmail(String email) {
      this.email = email;
   }

   public String getLevel() {
      return level;
   }
   
   public void setLevel(String level) {
      this.level = level;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      
      if (obj == null)
         return false;
      
      if (getClass() != obj.getClass())
         return false;
      
      Reservation other = (Reservation) obj;
      
      if (cityName == null) {
         if (other.cityName != null)
            return false;
      } else if (!cityName.equals(other.cityName))
         return false;
      
      if (email == null) {
         if (other.email != null)
            return false;
      } else if (!email.equals(other.email))
         return false;
      
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      
      if (level == null) {
         if (other.level != null)
            return false;
      } else if (!level.equals(other.level))
         return false;
      
      return true;
   }

   @Override
   public String toString() {
      return "Reservation [id=" + id + ", cityName=" + cityName + ", email="
            + email + ", level=" + level + "]";
   }
}

