package com.mbamgn.moviecatalogue.utils

import com.mbamgn.moviecatalogue.R
import com.mbamgn.moviecatalogue.data.MovieEntity
import com.mbamgn.moviecatalogue.data.TvShowEntity

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {
        val movie = ArrayList<MovieEntity>()

        movie.add(MovieEntity(
            "M1",
            "Bohemian Rhapsody",
            R.drawable.poster_bohemian,
            "Fearless lives forever",
            80F,
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "Music ,  Drama ,  History",
            "2h 15m"
        ))

        movie.add(MovieEntity(
            "M2",
            "A Star Is Born",
            R.drawable.poster_a_start_is_born,
            "-",
            75F,
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "Drama, Romance",
            "2h 16m"
        ))

        movie.add(MovieEntity(
            "M3",
            "How To Train Your Dragon",
            R.drawable.poster_how_to_train,
            "One adventure will change two worlds",
            78F,
            "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
            "Fantasy ,  Adventure ,  Animation ,  Family",
            "1h 38m"
        ))

        movie.add(MovieEntity(
            "M4",
            "Avengers: Infinity War",
            R.drawable.poster_infinity_war,
            "An entire universe. Once and for all.",
            83F,
            "As the Avengers and their allies continue to protect the world from threats too great for a single hero to handle, a new danger has emerged from the cosmic shadow: Thanos. An intergalactic despot of blasphemy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict a twisted will upon all of reality. Everything the Avengers have fought for has evolved to this point - the fate of Earth and its very existence has never been more certain.",
            "Adventure ,  Action ,  Fiction",
            "2h 29m"
        ))

        movie.add(MovieEntity(
            "M5",
            "T-34",
            R.drawable.poster_t34,
            "Fast And Furious On Tanks",
            70F,
            "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
            "War, Action, Drama, History",
            "2h 19m"
        ))

        movie.add(MovieEntity(
            "M6",
            "Ralph Breaks the Internet",
            R.drawable.poster_ralph,
            "Who Broke the Internet?",
            72F,
            "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
            "Family, Animation, Comedy, Adventure",
            "1h 52m"
        ))

        movie.add(MovieEntity(
            "M7",
            "Spider-Man: Into the Spider-Verse",
            R.drawable.poster_spiderman,
            "More than one wears the mask.",
            84F,
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            "Action, Adventure, Animation, Science Fiction, Comedy",
            "1h 57m"
        ))

        movie.add(MovieEntity(
            "M8",
            "Alita: Battle Angel",
            R.drawable.poster_alita,
            "An angel falls. A warrior rises.",
            72F,
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "Action, Science Fiction, Adventure",
            "2h 2m"
        ))

        movie.add(MovieEntity(
            "M9",
            "Aquaman",
            R.drawable.poster_aquaman,
            "Home Is Calling",
            69F,
            "vOnce home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "Action, Adventure, Fantasy",
            "2h 23m"
        ))

        movie.add(MovieEntity(
            "M10",
            "Fantastic Beasts: The Crimes of Grindelwald",
            R.drawable.poster_arrow,
            "Fate of One. Future of All.",
            69F,
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "Adventure, Fantasy, Drama",
            "2h 14m"
        ))

        return movie
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(TvShowEntity(
            "T1",
            "The Simpsons",
            R.drawable.poster_the_simpson,
            "On your marks, get set, d'oh!",
            79F,
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "Family, Animation, Comedy",
            "22m"
        ))

        tvShow.add(TvShowEntity(
            "T2",
            "Marvel's Iron Fist ",
            R.drawable.poster_iron_fist,
            "-",
            66F,
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            "Action & Adventure, Drama, Sci-Fi & Fantasy",
            "55m"
        ))

        tvShow.add(TvShowEntity(
            "T3",
            "Family Guy",
            R.drawable.poster_family_guy,
            "Parental Discretion Advised, that's how you know it's good",
            71F,
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "Animation, Comedy",
            "22m"
        ))

        tvShow.add(TvShowEntity(
            "T4",
            "Grey's Anatomy",
            R.drawable.poster_grey_anatomy,
            "The life you save may be your own.",
            82F,
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "Drama",
            "43m"
        ))

        tvShow.add(TvShowEntity(
            "T5",
            "Naruto Shippūden",
            R.drawable.poster_naruto_shipudden,
            "-",
            86F,
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            "25m"
        ))

        tvShow.add(TvShowEntity(
            "T6",
            "Arrow",
            R.drawable.poster_arrow,
            "Heroes fall. Legends rise.",
            67F,
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "Crime, Drama, Mystery, Action & Adventure",
            "42m"
        ))

        tvShow.add(TvShowEntity(
            "T7",
            "Hanna",
            R.drawable.poster_hanna,
            "-",
            76F,
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "Action & Adventure, Drama",
            "50"
        ))

        tvShow.add(TvShowEntity(
            "T8",
            "The Walking Dead",
            R.drawable.poster_the_walking_dead,
            "Fight the dead. Fear the living.",
            81F,
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "Action & Adventure, Drama, Sci-Fi & Fantasy",
            "42m"
        ))

        tvShow.add(TvShowEntity(
            "T9",
            "Dragon Ball",
            R.drawable.poster_dragon_ball,
            "-",
            82F,
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            "25m"
        ))

        tvShow.add(TvShowEntity(
            "T10",
            "Fairy Tail",
            R.drawable.poster_fairytail,
            "-",
            78F,
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery",
            "25m"
        ))

        return tvShow

    }

}