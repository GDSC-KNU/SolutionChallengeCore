package gdsc.knu.dlycmntwrk.domain

import jakarta.persistence.*
import org.locationtech.jts.geom.Point

@Entity
class Office (
    var name: String = "",
    @Column(nullable = false, columnDefinition = "GEOMETRY")
    var location: Point? = null
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}