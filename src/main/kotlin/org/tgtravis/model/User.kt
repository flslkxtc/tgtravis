package org.tgtravis.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column
import javax.persistence.ManyToMany
import javax.persistence.JoinTable
import javax.persistence.JoinColumn
import javax.persistence.FetchType

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @Column(unique = true, nullable = false)
    var telegramId: Long = 0,

    @Column(nullable = true)
    var telegramUserName: String? = "",

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserRepos",
            joinColumns = [JoinColumn(name = "user_id")],
            inverseJoinColumns = [(JoinColumn(name = "repo_id"))]
    )
    var repos: Set<Repo>? = HashSet()

) {
    constructor(telegramId: Long, telegramUserName: String?) : this(null, telegramId, telegramUserName, null)
}
