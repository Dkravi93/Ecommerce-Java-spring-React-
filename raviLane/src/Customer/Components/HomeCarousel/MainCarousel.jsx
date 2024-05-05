import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import { mainCarousel } from './MainCarouselData';

const responsive = {
    0: { items: 1 },
    568: { items: 2 },
    1024: { items: 3 },
};

const MainCarousel = () => {
    const items = mainCarousel.map((items, index) =>{
        return (
            <div key={index} className="h-screen flex items-center justify-center">
                <img
                    data-value={index}
                    className='cursor-pointer object-cover w-full max-h-50vh'
                    src={items.image} 
                    alt={''}
                />
            </div>
        );
    });
    return (
        <AliceCarousel
        items={items}
        disableButtonsControls
        autoPlay
        autoPlayInterval={1000}
        infinite
        innerWidth={100}
        // responsive={responsive}
        />
    )
}

export default MainCarousel
