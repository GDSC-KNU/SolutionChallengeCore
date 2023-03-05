package gdsc.knu.dlycmntwrk.repository

import gdsc.knu.dlycmntwrk.domain.Office
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface OfficeRepository : JpaRepository<Office, Long> {

    @Query(
        value = "select * from Office as o where MBRContains(ST_LINESTRINGFROMTEXT(:line_string), o.location)",
        nativeQuery = true
    )
    fun findAllByLocationsBetween(@Param("line_string") lineString: String): List<Office>
}