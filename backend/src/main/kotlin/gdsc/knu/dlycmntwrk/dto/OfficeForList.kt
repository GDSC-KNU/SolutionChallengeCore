package gdsc.knu.dlycmntwrk.dto

import gdsc.knu.dlycmntwrk.domain.Office

data class OfficeForList(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double
)

fun officeToOfficeForList(office: Office): OfficeForList {
    return OfficeForList(
        id = office.id!!,
        name = office.name,
        latitude = office.location.y,
        longitude = office.location.x
    )
}