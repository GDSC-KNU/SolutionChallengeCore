package gdsc.knu.dlycmntwrk.domain

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity

@Entity
class ItemCount(
    var count: Int = 0
) {
    @EmbeddedId
    val itemCountKEy: ItemCountKey? = null
}