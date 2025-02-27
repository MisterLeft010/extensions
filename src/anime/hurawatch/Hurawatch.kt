package eu.kanade.tachiyomi.animeextension.en.hurawatch

import eu.kanade.tachiyomi.animesource.AnimeHttpSource
import eu.kanade.tachiyomi.animesource.model.*
import eu.kanade.tachiyomi.network.GET
import eu.kanade.tachiyomi.network.POST
import okhttp3.Request
import org.jsoup.nodes.Document
import org.jsoup.Jsoup

class Hurawatch : AnimeHttpSource() {
    override val name = "Hurawatch"
    override val baseUrl = "https://hurawatch.cc"
    override val lang = "en"
    override val supportsLatest = true

    override fun popularAnimeRequest(page: Int): Request {
        return GET("$baseUrl/filter?sort=most_viewed&page=$page", headers)
    }

    override fun popularAnimeParse(response: okhttp3.Response): AnimesPage {
        val document = response.asJsoup()
        val animeList = document.select(".flw-item").map { element ->
            SAnime.create().apply {
                title = element.select(".film-name a").text()
                setUrlWithoutDomain(element.select(".film-name a").attr("href"))
                thumbnail_url = element.select(".film-poster img").attr("data-src")
            }
        }
        val hasNextPage = document.select(".pagination .page-item:last-child a").isNotEmpty()
        return AnimesPage(animeList, hasNextPage)
    }

    override fun episodeListParse(response: okhttp3.Response): List<SEpisode> {
        val document = response.asJsoup()
        return document.select(".episodes-item").mapIndexed { index, element ->
            SEpisode.create().apply {
                name = element.select("a").text()
                episode_number = (index + 1).toFloat()
                setUrlWithoutDomain(element.select("a").attr("href"))
            }
        }
    }

    override fun videoListParse(response: okhttp3.Response): List<Video> {
        val document = response.asJsoup()
        val videoList = mutableListOf<Video>()

        document.select("iframe").forEach { element ->
            val url = element.attr("src")
            if (url.isNotEmpty()) {
                videoList.add(Video(url, "Hurawatch Stream", url))
            }
        }
        return videoList
    }

    override fun searchAnimeRequest(page: Int, query: String, filters: AnimeFilterList): Request {
        return GET("$baseUrl/search?keyword=$query&page=$page", headers)
    }

    override fun searchAnimeParse(response: okhttp3.Response): AnimesPage {
        return popularAnimeParse(response)
    }
}
